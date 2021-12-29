package ro.ilearn.dcpm.order.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.common.AppConstants;
import ro.ilearn.dcpm.order.core.domain.Order;
import ro.ilearn.dcpm.order.core.port.OrderFinderPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderFinderJpaAdapter implements OrderFinderPort {
    private final PurchaseOrderFindRepository purchaseOrderFindRepository;

    /**
     * @param orderId the identifier of the order
     * @return the order with the given identifier or Optional#empty() if none found.
     * @throws IllegalArgumentException – if orderId is null.
     */
    @Override
    public Optional<Order> getOrderWithPositions(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, " orderId"));
        }
        return purchaseOrderFindRepository.getOrderWithPositions(orderId);
    }
}
