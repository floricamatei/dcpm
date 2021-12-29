package ro.ilearn.dcpm.orderinfo.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderPosition {
    private Long id;
    private String book;
    private int quantity;
    private Boolean available;

}