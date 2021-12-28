package ro.ilearn.dcpm.order.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.order.core.PurchaseOrderQueryPort;
import ro.ilearn.dcpm.order.core.PurchaseOrder;

@Component
@RequiredArgsConstructor
public class PurchaseOrderQueryAdapter implements PurchaseOrderQueryPort {
    private final PurchaseOrderFindRepository purchaseOrderFindRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public PurchaseOrder getOrderWithPositions(Long orderId) {
        return purchaseOrderMapper.toDomain(purchaseOrderFindRepository.getOrderWithPositions(orderId));
    }
}
