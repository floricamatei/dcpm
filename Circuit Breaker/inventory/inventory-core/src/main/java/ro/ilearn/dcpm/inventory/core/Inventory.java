package ro.ilearn.dcpm.inventory.core;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class Inventory implements SelfBeanValidating<Inventory> {
    private Long id;
    @NotNull
    private Long bookId;
    @Min(0)
    private int quantity;
}
