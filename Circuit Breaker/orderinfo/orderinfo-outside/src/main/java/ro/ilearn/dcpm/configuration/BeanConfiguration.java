package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.orderinfo.core.*;


@Configuration
public class BeanConfiguration {

    @Bean
    public ViewOrderInfoPort viewOrderInfoPort(
            BookQueryPort bookQueryPort,
            InventoryQueryPort inventoryQueryPort,
            OrderQueryPort orderQueryPort
    ) {
        return new ViewOrderInfo(bookQueryPort, inventoryQueryPort, orderQueryPort);
    }
}
