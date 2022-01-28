package ro.ilearn.dcpm.orderinfo.adapter.httpclient.order;

import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.orderinfo.core.domain.PurchaseOrder;

@Component
public class OrderServiceClientFallback implements OrderServiceClient {

    @Override
    public PurchaseOrder getOrder(Long orderId) {
        return PurchaseOrder.builder()
                .id(-1L)
                .build();
    }

}
