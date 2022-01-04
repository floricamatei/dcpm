package ro.ilearn.dcpm.orderinfo.core;

import lombok.RequiredArgsConstructor;
import ro.ilearn.dcpm.common.AppConstants;
import ro.ilearn.dcpm.orderinfo.core.domain.*;
import ro.ilearn.dcpm.orderinfo.core.port.BookFinderPort;
import ro.ilearn.dcpm.orderinfo.core.port.InventoryFinderPort;
import ro.ilearn.dcpm.orderinfo.core.port.OrderFinderPort;
import ro.ilearn.dcpm.orderinfo.core.port.ViewOrderInfoPort;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class ViewOrderInfo implements ViewOrderInfoPort {
    private final BookFinderPort bookFinderPort;
    private final InventoryFinderPort inventoryFinderPort;
    private final OrderFinderPort orderFinderPort;

    /**
     * @param orderId the identifier of the order
     * @return the order info with the given identifier or throw
     *         NoSuchElementException if none found.
     * @throws IllegalArgumentException – if orderId is null.
     * @throws NoSuchElementException   - if order not found by given identifier
     */
    @Override
    public OrderInfo execute(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "orderId"));
        }
        PurchaseOrder order = orderFinderPort.getOrder(orderId);
        OrderInfo info = OrderInfo.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .state(order.getState())
                .build();
        List<OrderPosition> positions = new ArrayList<>();
        if (order.getPositions() != null) {
            for (PurchaseOrderPosition p : order.getPositions()) {
                Book book = bookFinderPort.getBook(p.getBookId());
                String titleAuthors = book.getTitle() != null ? book.getTitle() : "";
                if (book.getAuthors() != null) {
                    titleAuthors = titleAuthors + " - " + book.getAuthors();
                }
                OrderPosition pos = OrderPosition.builder()
                        .id(p.getId())
                        .quantity(p.getQuantity())
                        .book(titleAuthors)
                        .available(inventoryFinderPort.getInventory(book.getId()) >= p.getQuantity())
                        .build();
                positions.add(pos);
            }
        }
        info.addOrderPositions(positions);
        return info;
    }
}
