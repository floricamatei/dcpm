package ro.ilearn.dcpm.inventory.core.port;

import ro.ilearn.dcpm.inventory.core.domain.Inventory;

public interface ViewCurrentBookInventoryPort {
    Inventory execute(Long bookId);
}
