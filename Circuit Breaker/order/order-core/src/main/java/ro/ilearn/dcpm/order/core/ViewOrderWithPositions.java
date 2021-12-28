package ro.ilearn.dcpm.order.core;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ViewOrderWithPositions implements ViewOrderWithPositionsPort {
    private final PurchaseOrderQueryPort purchaseOrderQueryPort;

    @Override
    public PurchaseOrder execute(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException();
        }
        return purchaseOrderQueryPort.getOrderWithPositions(orderId);
    }
}
