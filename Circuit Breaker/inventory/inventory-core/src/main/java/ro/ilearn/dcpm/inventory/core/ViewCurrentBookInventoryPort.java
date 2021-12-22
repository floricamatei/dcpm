package ro.ilearn.dcpm.inventory.core;

public interface ViewCurrentBookInventoryPort {
    Inventory execute(Long bookId);
}
