package ro.ilearn.dcpm.orderinfo.core.port;

import ro.ilearn.dcpm.orderinfo.core.domain.OrderInfo;

public interface ViewOrderInfoPort {
    OrderInfo execute(Long orderId);
}
