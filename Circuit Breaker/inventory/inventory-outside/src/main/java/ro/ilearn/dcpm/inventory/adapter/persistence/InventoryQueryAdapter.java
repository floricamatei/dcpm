package ro.ilearn.dcpm.inventory.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.inventory.core.Inventory;
import ro.ilearn.dcpm.inventory.core.InventoryQueryPort;

@Component
@RequiredArgsConstructor
public class InventoryQueryAdapter implements InventoryQueryPort {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Override
    public Inventory findBookById(Long bookId) {
        return inventoryMapper.toDomain(inventoryRepository.findByBookId(bookId));
    }
}
