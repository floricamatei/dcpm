package ro.ilearn.dcpm.orderinfo.adapter.httpclient.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory", fallbackFactory = InventoryServiceClientFallbackFactory.class)
public interface InventoryServiceClient {
    @GetMapping(path = "/api/v1/inventories/book/{bookId}")
    int getinventory(@PathVariable("bookId") Long bookId);
}
