package ro.ilearn.dcpm.orderinfo.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
public class PurchaseOrder {
    private Long id;
    private String customerName;
    private Set<PurchaseOrderPosition> positions = new HashSet<>();
    private OrderState state;

}