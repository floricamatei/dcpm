package ro.ilearn.dcpm.orderinfo.adapter.httpclient.inventory;

import org.springframework.stereotype.Component;

@Component
public class InventoryServiceClientFallback implements InventoryServiceClient {

    @Override
    public int getinventory(Long bookId) {
        return 0;
    }

}
