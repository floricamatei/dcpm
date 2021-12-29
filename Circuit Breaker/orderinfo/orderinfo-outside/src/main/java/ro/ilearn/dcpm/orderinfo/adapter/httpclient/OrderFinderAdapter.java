package ro.ilearn.dcpm.orderinfo.adapter.httpclient;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.orderinfo.core.port.OrderFinderPort;
import ro.ilearn.dcpm.orderinfo.core.domain.PurchaseOrder;


@Component
@RequiredArgsConstructor
public class OrderFinderAdapter implements OrderFinderPort {
    private final Logger logger = LoggerFactory.getLogger(OrderFinderAdapter.class);
    private final OrderClient orderClient;


    @Override
    public PurchaseOrder getOrder(Long orderId) {
        logger.info("Calling REST endpoint of order service ...");
        return orderClient.getOrder(orderId);
    }
}
