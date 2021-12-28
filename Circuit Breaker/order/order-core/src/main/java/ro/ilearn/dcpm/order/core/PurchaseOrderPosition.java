package ro.ilearn.dcpm.order.core;

import lombok.Builder;
import lombok.Getter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class PurchaseOrderPosition implements SelfBeanValidating<PurchaseOrderPosition> {
    private Long id;
    @NotNull
    private Long bookId;
    @Min(1)
    private int quantity;
}
