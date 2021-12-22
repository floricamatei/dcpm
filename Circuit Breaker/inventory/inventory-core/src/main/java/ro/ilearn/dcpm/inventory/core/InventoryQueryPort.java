package ro.ilearn.dcpm.inventory.core;

public interface InventoryQueryPort {
    Inventory findBookById(Long bookId);
}