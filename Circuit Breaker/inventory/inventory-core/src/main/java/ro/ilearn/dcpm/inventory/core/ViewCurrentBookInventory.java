package ro.ilearn.dcpm.inventory.core;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ViewCurrentBookInventory implements ViewCurrentBookInventoryPort {
    private final InventoryQueryPort inventoryQueryPort;

    @Override
    public Inventory execute(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException();
        }
        return inventoryQueryPort.findBookById(bookId);
    }
}
