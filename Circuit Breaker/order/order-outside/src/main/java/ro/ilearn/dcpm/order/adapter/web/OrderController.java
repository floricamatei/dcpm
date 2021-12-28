package ro.ilearn.dcpm.order.adapter.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.order.core.PurchaseOrder;
import ro.ilearn.dcpm.order.core.ViewOrderWithPositionsPort;

@RestController
@RequestMapping(path = "/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class.getSimpleName());
    private final ViewOrderWithPositionsPort viewOrderWithPositionsPort;

    @GetMapping(path = "/{id}")
    public PurchaseOrder getOrder(@PathVariable("id") Long orderId) {
        return viewOrderWithPositionsPort.execute(orderId);
    }
}