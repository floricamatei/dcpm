package ro.ilearn.dcpm.order.adapter.persistence;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PurchaseOrderPositionDto {
    private Long id;
    private Long bookId;
    private int quantity;
}
