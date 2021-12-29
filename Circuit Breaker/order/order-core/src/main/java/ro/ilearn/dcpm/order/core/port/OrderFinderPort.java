package ro.ilearn.dcpm.order.core.port;

import ro.ilearn.dcpm.order.core.domain.Order;

import java.util.Optional;

public interface OrderFinderPort {
    Optional<Order> getOrderWithPositions(Long orderId);
}