package ro.ilearn.dcpm.order.adapter.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.order.core.domain.Order;
import ro.ilearn.dcpm.order.core.port.ViewOrderWithPositionsPort;

@RestController
@RequestMapping(path = "/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class.getSimpleName());
    private final ViewOrderWithPositionsPort viewOrderWithPositionsPort;

    @Operation(summary = "Get a order by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class)) })
    })
    @GetMapping(path = "/{id}")
    public Order getOrder(@PathVariable("id") Long orderId) {
        logger.info("Done ... returning order now");
        return viewOrderWithPositionsPort.execute(orderId);
    }
}