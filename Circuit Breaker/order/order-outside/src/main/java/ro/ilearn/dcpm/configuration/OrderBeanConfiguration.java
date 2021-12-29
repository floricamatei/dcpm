package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.order.core.port.OrderFinderPort;
import ro.ilearn.dcpm.order.core.ViewOrderWithPositions;

@Configuration
public class OrderBeanConfiguration {

    @Bean
    public ViewOrderWithPositions viewOrderWithPositions(OrderFinderPort orderFinderPort) {
        return new ViewOrderWithPositions(orderFinderPort);
    }
}
