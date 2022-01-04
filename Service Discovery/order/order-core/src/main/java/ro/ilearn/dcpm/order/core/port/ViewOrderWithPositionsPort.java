package ro.ilearn.dcpm.order.core.port;

import ro.ilearn.dcpm.order.core.domain.Order;

public interface ViewOrderWithPositionsPort {
    Order execute(Long orderId);
}
