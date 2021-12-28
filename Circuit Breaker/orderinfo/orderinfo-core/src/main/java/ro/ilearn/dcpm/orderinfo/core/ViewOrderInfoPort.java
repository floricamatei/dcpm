package ro.ilearn.dcpm.orderinfo.core;

public interface ViewOrderInfoPort {
    OrderInfo execute(Long orderId);
}
