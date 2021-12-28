package ro.ilearn.dcpm.orderinfo.core;

public interface OrderQueryPort {
    PurchaseOrder getOrder(Long orderId);
}
