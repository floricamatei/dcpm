package ro.ilearn.dcpm.inventory.core;

import lombok.RequiredArgsConstructor;
import ro.ilearn.dcpm.common.AppConstants;
import ro.ilearn.dcpm.inventory.core.domain.Inventory;
import ro.ilearn.dcpm.inventory.core.port.InventoryFinderPort;
import ro.ilearn.dcpm.inventory.core.port.ViewCurrentBookInventoryPort;

import java.util.NoSuchElementException;


@RequiredArgsConstructor
public class ViewCurrentBookInventory implements ViewCurrentBookInventoryPort {
    private final InventoryFinderPort inventoryFinderPort;

    /**
     * @param bookId the identifier of the book
     * @return the inventory for the book or throw NoSuchElementException if none found.
     * @throws IllegalArgumentException – if bookId is null.
     * @throws NoSuchElementException   - if inventory not found for the book
     */
    @Override
    public Inventory execute(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "bookId"));
        }
        return inventoryFinderPort.findBookById(bookId).orElseThrow(() ->
                new NoSuchElementException(String.format(AppConstants.NOT_INVENTORY_FOR_BOOK, "Inventory", bookId))
        );
    }
}
