package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.orderinfo.core.ViewOrderInfo;
import ro.ilearn.dcpm.orderinfo.core.port.BookFinderPort;
import ro.ilearn.dcpm.orderinfo.core.port.InventoryFinderPort;
import ro.ilearn.dcpm.orderinfo.core.port.OrderFinderPort;
import ro.ilearn.dcpm.orderinfo.core.port.ViewOrderInfoPort;


@Configuration
public class BeanConfiguration {

    @Bean
    public ViewOrderInfoPort viewOrderInfoPort(
            BookFinderPort bookFinderPort,
            InventoryFinderPort inventoryFinderPort,
            OrderFinderPort orderFinderPort
    ) {
        return new ViewOrderInfo(bookFinderPort, inventoryFinderPort, orderFinderPort);
    }
}
