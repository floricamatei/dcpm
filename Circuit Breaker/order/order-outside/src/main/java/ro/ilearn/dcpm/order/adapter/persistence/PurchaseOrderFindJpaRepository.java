package ro.ilearn.dcpm.order.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ro.ilearn.dcpm.order.core.PurchaseOrderState;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class PurchaseOrderFindJpaRepository implements PurchaseOrderFindRepository {
    public static final String ORDER_ID = "orderId";
    private final EntityManager em;

    @Override
    public PurchaseOrderrDto getOrderWithPositions(Long orderId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
        // From
        Root<PurchaseOrderPositionJpaEntity> orderPositionRoot = cq.from(PurchaseOrderPositionJpaEntity.class);
        Join<PurchaseOrderPositionJpaEntity, PurchaseOrderJpaEntity> orderJoin = orderPositionRoot.join(PurchaseOrderPositionJpaEntity_.order);
        // Select
        cq.multiselect(
                orderPositionRoot.get(PurchaseOrderPositionJpaEntity_.id).alias(PurchaseOrderPositionJpaEntity_.ID),
                orderPositionRoot.get(PurchaseOrderPositionJpaEntity_.bookId).alias(PurchaseOrderPositionJpaEntity_.BOOK_ID),
                orderPositionRoot.get(PurchaseOrderPositionJpaEntity_.quantity).alias(PurchaseOrderPositionJpaEntity_.QUANTITY),
                orderJoin.get(PurchaseOrderJpaEntity_.id).alias(ORDER_ID),
                orderJoin.get(PurchaseOrderJpaEntity_.customerName).alias(PurchaseOrderJpaEntity_.CUSTOMER_NAME),
                orderJoin.get(PurchaseOrderJpaEntity_.amount).alias(PurchaseOrderJpaEntity_.AMOUNT),
                orderJoin.get(PurchaseOrderJpaEntity_.state).alias(PurchaseOrderJpaEntity_.STATE)
        );
        // WHERE
        cq.where(buildWhere(cb, orderJoin, orderId));
        // Execute query
        List<Tuple> tupleLst = em.createQuery(cq).getResultList();
        //
        List<PurchaseOrderrDto> list = fromTupleToDto(tupleLst);
        return list.get(0);
    }

    private Predicate[] buildWhere(CriteriaBuilder cb, Join<PurchaseOrderPositionJpaEntity, PurchaseOrderJpaEntity> orderJoin, Long orderId) {
        List<Predicate> predicates = new ArrayList<>();
        // order id
        predicates.add(cb.equal(orderJoin.get(PurchaseOrderJpaEntity_.id), orderId));
        //
        return predicates.toArray(new Predicate[]{});
    }

    private List<PurchaseOrderrDto> fromTupleToDto(List<Tuple> tupleLst) {
        // multime id-uri de parinti distincte
        Set<Long> idsParent = new HashSet<>();
        // parinte curent
        PurchaseOrderrDto parent = PurchaseOrderrDto.builder().build();
        // lista parinti de returnat
        List<PurchaseOrderrDto> parents = new ArrayList<>();
        if (!tupleLst.isEmpty()) {
            for (Tuple tuple : tupleLst) {
                // id parinte
                Long idParent = tuple.get(ORDER_ID, Long.class);
                if (idsParent.contains(idParent)) {
                    // am deja parintele ... adaug copilul la parintele curent
                    addCopilLaParinte(tuple, parent);
                } else {
                    // am parinte nou; adaug id parinte curent la multime id-uri parinte
                    idsParent.add(idParent);
                    // creez parinte curent
                    parent = PurchaseOrderrDto.builder()
                            .id(tuple.get(ORDER_ID, Long.class))
                            .amount(tuple.get(PurchaseOrderJpaEntity_.AMOUNT, BigDecimal.class))
                            .customerName(tuple.get(PurchaseOrderJpaEntity_.CUSTOMER_NAME, String.class))
                            .state(tuple.get(PurchaseOrderJpaEntity_.STATE, PurchaseOrderState.class))
                            .build();
                    // adaug parinte curent lista parinti de returnat
                    parents.add(parent);
                    // daca are copil i-l adaug la parinte
                    if (tuple.get(PurchaseOrderPositionJpaEntity_.ID, Long.class) != null) {
                        addCopilLaParinte(tuple, parent);
                    }
                }
            }
        }
        return parents;
    }

    private void addCopilLaParinte(Tuple tuple, PurchaseOrderrDto parinte) {
        // creez copil curent
        PurchaseOrderPositionDto copil = PurchaseOrderPositionDto.builder()
                .id(tuple.get(PurchaseOrderPositionJpaEntity_.ID, Long.class))
                .bookId(tuple.get(PurchaseOrderPositionJpaEntity_.BOOK_ID, Long.class))
                .quantity(tuple.get(PurchaseOrderPositionJpaEntity_.QUANTITY, Integer.class))
                .build();
        // adaug copil la parinte curent
        parinte.addOrderPosition(copil);
    }
}
