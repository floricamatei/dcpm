package ro.ilearn.dcpm.orderinfo.adapter.httpclient.order;

import lombok.extern.slf4j.Slf4j;
import ro.ilearn.dcpm.orderinfo.core.domain.PurchaseOrder;

@Slf4j
public class OrderServiceClientFallbackWithFactory implements OrderServiceClient {
    private final Throwable cause;

    public OrderServiceClientFallbackWithFactory(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public PurchaseOrder getOrder(Long orderId) {
        log.info(cause.getMessage(), cause);
        return getOrderFallback();
    }

    private PurchaseOrder getOrderFallback() {
        return PurchaseOrder.builder()
                .id(-1L)
                .build();
    }

}
