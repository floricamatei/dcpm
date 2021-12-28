package ro.ilearn.dcpm.orderinfo.core;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ViewOrderInfo implements ViewOrderInfoPort {
    private final BookQueryPort bookQueryPort;
    private final InventoryQueryPort inventoryQueryPort;
    private final OrderQueryPort orderQueryPort;

    @Override
    public OrderInfo execute(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException();
        }
        PurchaseOrder order = orderQueryPort.getOrder(orderId);
        OrderInfo info = OrderInfo.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .state(order.getState())
                .build();
        List<OrderPosition> positions = new ArrayList<>();
        for (PurchaseOrderPosition p : order.getPositions()) {
            Book book = bookQueryPort.getBook(p.getBookId());
            OrderPosition pos = OrderPosition.builder()
                    .id(p.getId())
                    .quantity(p.getQuantity())
                    .book(book.getTitle() + " - " + book.getAuthors())
                    .available(inventoryQueryPort.getInventory(book.getId()) >= p.getQuantity())
                    .build();
            positions.add(pos);
        }
        info.addOrderPositions(positions);
        return info;
    }
}
