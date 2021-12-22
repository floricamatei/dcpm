package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.inventory.core.InventoryQueryPort;
import ro.ilearn.dcpm.inventory.core.ViewCurrentBookInventory;

@Configuration
public class InventoryBeanConfiguration {

    @Bean
    public ViewCurrentBookInventory viewCurrentBookInventory(InventoryQueryPort inventoryQueryPort) {
        return new ViewCurrentBookInventory(inventoryQueryPort);
    }
}
