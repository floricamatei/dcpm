package ro.ilearn.dcpm.order.core;

public interface PurchaseOrderQueryPort {
    PurchaseOrder getOrderWithPositions(Long orderId);
}