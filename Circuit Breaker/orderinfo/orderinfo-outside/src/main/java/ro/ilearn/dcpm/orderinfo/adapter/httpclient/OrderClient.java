package ro.ilearn.dcpm.orderinfo.adapter.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.ilearn.dcpm.orderinfo.core.PurchaseOrder;

@FeignClient(value = "order-client", url = "${dcpm.order-api-host}/api/v1/orders")
public interface OrderClient {
    @GetMapping(path = "/{orderId}")
    PurchaseOrder getOrder(@PathVariable("orderId") Long orderId);
}
