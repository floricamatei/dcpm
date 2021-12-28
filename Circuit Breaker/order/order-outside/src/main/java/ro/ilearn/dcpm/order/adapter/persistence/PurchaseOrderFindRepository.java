package ro.ilearn.dcpm.order.adapter.persistence;


public interface PurchaseOrderFindRepository {

    PurchaseOrderrDto getOrderWithPositions(Long orderId);
}