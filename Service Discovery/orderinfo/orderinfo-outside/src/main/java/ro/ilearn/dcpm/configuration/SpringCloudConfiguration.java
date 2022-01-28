package ro.ilearn.dcpm.configuration;

import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.orderinfo.adapter.httpclient.book.BookServiceClient;
import ro.ilearn.dcpm.orderinfo.adapter.httpclient.inventory.InventoryServiceClient;
import ro.ilearn.dcpm.orderinfo.adapter.httpclient.order.OrderServiceClient;

import java.time.Duration;

@Configuration
@EnableFeignClients(clients = { BookServiceClient.class, InventoryServiceClient.class, OrderServiceClient.class })
public class SpringCloudConfiguration {
    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> slowBackendCustomizer() {
        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(1L)) // default = 1L
                .build();
        return factory -> factory.configure(builder -> builder.timeLimiterConfig(timeLimiterConfig).build(),
                "BookServiceClient#getBook(Long)");
    }
}
