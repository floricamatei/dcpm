package ro.ilearn.dcpm.orderinfo.adapter.httpclient;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.orderinfo.core.InventoryQueryPort;


@Component
@RequiredArgsConstructor
public class InventoryQueryAdapter implements InventoryQueryPort {
    private final Logger logger = LoggerFactory.getLogger(InventoryQueryAdapter.class);
    private final InventoryClient inventoryClient;


    @Override
    public int getInventory(Long bookId) {
        logger.info("Calling REST endpoint of inventory service ...");
        return inventoryClient.getinventory(bookId);
    }
}
