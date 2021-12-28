package ro.ilearn.dcpm.order.core;

import lombok.Builder;
import lombok.Getter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class PurchaseOrder implements SelfBeanValidating<PurchaseOrder> {
    private Long id;
    @NotNull
    @Size(max = 255)
    private String customerName;
    @NotNull
    private BigDecimal amount;
    @NotEmpty
    private List<PurchaseOrderPosition> positions;
    @NotNull
    private PurchaseOrderState state;
}
