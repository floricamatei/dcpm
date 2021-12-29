package ro.ilearn.dcpm.order.core.domain;

import lombok.Builder;
import lombok.Getter;
import ro.ilearn.dcpm.common.AppConstants;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class Order implements SelfBeanValidating<Order> {
    private Long id;
    @NotNull
    @Size(max = 255)
    private String customerName;
    @NotNull
    private BigDecimal amount;
    @NotEmpty
    private List<OrderPosition> positions;
    @NotNull
    private OrderState state;

    public void addPositions(List<OrderPosition> positionsToAdd) {
        if (positions == null) {
            positions = new ArrayList<>();
        }
        if (positionsToAdd != null) {
            positions.addAll(positionsToAdd);
        }
    }

    public void addPosition(OrderPosition position) {
        if (position == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "position"));
        }
        if (positions == null) {
            positions = new ArrayList<>();
        }
        positions.add(position);
    }
}
