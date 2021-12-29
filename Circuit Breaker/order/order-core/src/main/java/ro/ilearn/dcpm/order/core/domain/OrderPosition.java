package ro.ilearn.dcpm.order.core.domain;

import lombok.Builder;
import lombok.Getter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class OrderPosition implements SelfBeanValidating<OrderPosition> {
    private Long id;
    @NotNull
    private Long bookId;
    @Min(1)
    private int quantity;
}
