package ro.ilearn.dcpm.orderinfo.adapter.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.orderinfo.core.domain.OrderInfo;
import ro.ilearn.dcpm.orderinfo.core.port.ViewOrderInfoPort;

@RestController
@RequestMapping(path = "/api/v1/orderinfo")
@RequiredArgsConstructor
@Slf4j
public class OrderInfoController {
    private final ViewOrderInfoPort viewOrderInfoPort;

    @GetMapping(path = "/{orderId}")
    public OrderInfo getOrderInformation(@PathVariable("orderId") Long orderId) {
        if (log.isInfoEnabled()) {
            log.info(String.format("Return information for order with id [%d]", orderId));
        }
        return viewOrderInfoPort.execute(orderId);

    }
}