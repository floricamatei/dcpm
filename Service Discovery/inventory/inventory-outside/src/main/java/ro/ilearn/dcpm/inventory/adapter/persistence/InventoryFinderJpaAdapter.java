package ro.ilearn.dcpm.inventory.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.common.AppConstants;
import ro.ilearn.dcpm.inventory.core.domain.Inventory;
import ro.ilearn.dcpm.inventory.core.port.InventoryFinderPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InventoryFinderJpaAdapter implements InventoryFinderPort {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    /**
     * @param bookId the identifier of the book
     * @return the inventory with the given book identifier or Optional#empty() if none found.
     * @throws IllegalArgumentException – if bookId is null.
     */
    @Override
    public Optional<Inventory> findBookById(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "bookId"));
        }
        Optional<InventoryJpaEntity> optionalInventoryJpaEntity = inventoryRepository.findById(bookId);
        return optionalInventoryJpaEntity.map(inventoryMapper::toDomain);
    }
}
