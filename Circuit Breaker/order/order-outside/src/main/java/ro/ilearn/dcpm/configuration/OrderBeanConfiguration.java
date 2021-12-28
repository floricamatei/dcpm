package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.order.core.PurchaseOrderQueryPort;
import ro.ilearn.dcpm.order.core.ViewOrderWithPositions;

@Configuration
public class OrderBeanConfiguration {

    @Bean
    public ViewOrderWithPositions viewOrderWithPositions(PurchaseOrderQueryPort purchaseOrderQueryPort) {
        return new ViewOrderWithPositions(purchaseOrderQueryPort);
    }
}
