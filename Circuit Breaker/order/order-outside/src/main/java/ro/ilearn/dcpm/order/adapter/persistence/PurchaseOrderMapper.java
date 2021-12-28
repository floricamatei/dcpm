package ro.ilearn.dcpm.order.adapter.persistence;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.order.core.PurchaseOrder;
import ro.ilearn.dcpm.order.core.PurchaseOrderPosition;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseOrderMapper {
    PurchaseOrder toDomain(PurchaseOrderrDto dto);

    PurchaseOrderPosition toDomain(PurchaseOrderPositionDto dto);

    List<PurchaseOrderPosition> toDomain(List<PurchaseOrderPositionDto> dtos);
}
