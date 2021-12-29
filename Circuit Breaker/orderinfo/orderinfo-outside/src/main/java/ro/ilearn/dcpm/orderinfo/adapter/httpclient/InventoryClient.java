package ro.ilearn.dcpm.orderinfo.adapter.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "inventory-client", url = "${dcpm.inventory-api-path}")
public interface InventoryClient {
    @GetMapping(path = "/book/{bookId}")
    int getinventory(@PathVariable("bookId") Long bookId);
}
