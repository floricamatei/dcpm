package ro.ilearn.dcpm.orderinfo.adapter.httpclient.inventory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryServiceClientFallbackWithFactory implements InventoryServiceClient {
    private final Throwable cause;

    public InventoryServiceClientFallbackWithFactory(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public int getinventory(Long bookId) {
        log.info(cause.getMessage(), cause);
        return 0;
    }

}
