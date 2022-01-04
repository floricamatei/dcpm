package ro.ilearn.dcpm.orderinfo.adapter.httpclient.inventory;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class InventoryServiceClientFallbackFactory
        implements FallbackFactory<InventoryServiceClientFallbackWithFactory> {
    @Override
    public InventoryServiceClientFallbackWithFactory create(Throwable cause) {
        return new InventoryServiceClientFallbackWithFactory(cause);
    }
}
