package ro.ilearn.dcpm.orderinfo.adapter.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.orderinfo.core.OrderInfo;
import ro.ilearn.dcpm.orderinfo.core.ViewOrderInfoPort;

@RestController
@RequestMapping(path = "/api/v1/orderinfo")
@RequiredArgsConstructor
public class OrderInfoController {

    private final Logger logger = LoggerFactory.getLogger(OrderInfoController.class);
    private final ViewOrderInfoPort viewOrderInfoPort;

    @GetMapping(path = "/{orderId}")
    public OrderInfo getOrderInformation(@PathVariable("orderId") Long orderId) {
        if (logger.isInfoEnabled()) {
            logger.info(String.format("Return information for order with id [%d]", orderId));
        }
        return viewOrderInfoPort.execute(orderId);

    }
}