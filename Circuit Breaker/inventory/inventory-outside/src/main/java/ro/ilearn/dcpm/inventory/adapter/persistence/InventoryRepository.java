package ro.ilearn.dcpm.inventory.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryJpaEntity, Long> {

    Optional<InventoryJpaEntity> findByBookId(Long bookId);
}