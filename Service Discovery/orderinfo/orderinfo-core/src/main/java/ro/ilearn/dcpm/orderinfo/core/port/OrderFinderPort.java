package ro.ilearn.dcpm.orderinfo.core.port;

import ro.ilearn.dcpm.orderinfo.core.domain.PurchaseOrder;

public interface OrderFinderPort {
    PurchaseOrder getOrder(Long orderId);
}
