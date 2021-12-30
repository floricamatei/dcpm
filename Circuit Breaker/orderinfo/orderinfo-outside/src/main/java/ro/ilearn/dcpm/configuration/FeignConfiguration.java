package ro.ilearn.dcpm.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.orderinfo.adapter.httpclient.BookServiceClient;
import ro.ilearn.dcpm.orderinfo.adapter.httpclient.InventoryServiceClient;
import ro.ilearn.dcpm.orderinfo.adapter.httpclient.OrderServiceClient;

@Configuration
@EnableFeignClients(clients = {BookServiceClient.class, InventoryServiceClient.class, OrderServiceClient.class})
public class FeignConfiguration {
}
