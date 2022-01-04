package ro.ilearn.dcpm.order.adapter.persistence;


import ro.ilearn.dcpm.order.core.domain.Order;

import java.util.Optional;

public interface PurchaseOrderFindRepository {

    Optional<Order> getOrderWithPositions(Long orderId);
}