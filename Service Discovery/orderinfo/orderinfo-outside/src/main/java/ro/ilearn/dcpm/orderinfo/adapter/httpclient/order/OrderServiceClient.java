package ro.ilearn.dcpm.orderinfo.adapter.httpclient.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.ilearn.dcpm.orderinfo.core.domain.PurchaseOrder;

@FeignClient(name = "order", fallbackFactory = OrderServiceClientFallbackFactory.class)
public interface OrderServiceClient {
    @GetMapping(path = "/api/v1/orders/{orderId}")
    PurchaseOrder getOrder(@PathVariable("orderId") Long orderId);
}
