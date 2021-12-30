package ro.ilearn.dcpm.inventory.core.port;

import ro.ilearn.dcpm.inventory.core.domain.Inventory;

import java.util.Optional;

public interface InventoryFinderPort {
    Optional<Inventory> findBookById(Long bookId);
}