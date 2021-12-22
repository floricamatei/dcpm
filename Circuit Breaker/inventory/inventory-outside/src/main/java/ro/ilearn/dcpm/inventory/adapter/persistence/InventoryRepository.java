package ro.ilearn.dcpm.inventory.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryJpaEntity, Long> {

    InventoryJpaEntity findByBookId(Long bookId);
}