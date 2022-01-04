package ro.ilearn.dcpm.order.core;

import lombok.RequiredArgsConstructor;
import ro.ilearn.dcpm.common.AppConstants;
import ro.ilearn.dcpm.order.core.domain.Order;
import ro.ilearn.dcpm.order.core.port.OrderFinderPort;
import ro.ilearn.dcpm.order.core.port.ViewOrderWithPositionsPort;

import java.util.NoSuchElementException;


@RequiredArgsConstructor
public class ViewOrderWithPositions implements ViewOrderWithPositionsPort {
    private final OrderFinderPort orderFinderPort;

    /**
     * @param orderId the identifier of the order
     * @return the order with the given identifier or throw NoSuchElementException if none found.
     * @throws IllegalArgumentException – if orderId is null.
     * @throws NoSuchElementException   - if order not found by given identifier
     */
    @Override
    public Order execute(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "orderId"));
        }
        return orderFinderPort.getOrderWithPositions(orderId).orElseThrow(() ->
                new NoSuchElementException(String.format(AppConstants.NOT_SUCH_ELEMENT, "Order", orderId))
        );
    }
}
