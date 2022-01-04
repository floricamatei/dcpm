package ro.ilearn.dcpm.orderinfo.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class OrderInfo {

    private Long id;
    private String customerName;
    private List<OrderPosition> positions;
    private OrderState state;

    public void addOrderPositions(List<OrderPosition> positionsToAdd) {
        if (positions == null) {
            positions = new ArrayList<>();
        }
        if (positionsToAdd != null) {
            this.positions.addAll(positionsToAdd);
        }
    }
}