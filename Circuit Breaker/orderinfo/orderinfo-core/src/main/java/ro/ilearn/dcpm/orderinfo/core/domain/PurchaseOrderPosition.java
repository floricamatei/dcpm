package ro.ilearn.dcpm.orderinfo.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PurchaseOrderPosition {
    private Long id;
    private int version;
    private Long bookId;
    private int quantity;
}