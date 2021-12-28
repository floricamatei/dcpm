package ro.ilearn.dcpm.order.adapter.persistence;

import lombok.Builder;
import lombok.Getter;
import ro.ilearn.dcpm.order.core.PurchaseOrderState;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class PurchaseOrderrDto {
    private Long id;
    private String customerName;
    private BigDecimal amount;
    private List<PurchaseOrderPositionDto> positions;
    private PurchaseOrderState state;

    public void addOrderPosition(PurchaseOrderPositionDto purchaseOrderPositionDto) {
        if (positions == null) {
            positions = new ArrayList<>();
        }
        this.positions.add(purchaseOrderPositionDto);
    }
}
