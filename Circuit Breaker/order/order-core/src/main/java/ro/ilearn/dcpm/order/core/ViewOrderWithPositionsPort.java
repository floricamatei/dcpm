package ro.ilearn.dcpm.order.core;

public interface ViewOrderWithPositionsPort {
    PurchaseOrder execute(Long orderId);
}
