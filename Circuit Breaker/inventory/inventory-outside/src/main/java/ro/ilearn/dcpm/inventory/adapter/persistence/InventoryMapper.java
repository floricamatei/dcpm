package ro.ilearn.dcpm.inventory.adapter.persistence;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.inventory.core.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    Inventory toDomain(InventoryJpaEntity entity);
}
