package ro.ilearn.dcpm.orderinfo.adapter.httpclient.order;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceClientFallbackFactory implements FallbackFactory<OrderServiceClientFallbackWithFactory> {
    @Override
    public OrderServiceClientFallbackWithFactory create(Throwable cause) {
        return new OrderServiceClientFallbackWithFactory(cause);
    }
}
