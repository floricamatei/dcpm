package ro.ilearn.dcpm.orderinfo.core;

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

    public void addOrderPositions(List<OrderPosition> positions) {
        if (this.positions == null) {
            this.positions = new ArrayList<>();
        }
        this.positions.addAll(positions);
    }
}