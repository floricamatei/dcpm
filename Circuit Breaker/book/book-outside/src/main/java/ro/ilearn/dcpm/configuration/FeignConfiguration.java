package ro.ilearn.dcpm.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.book.adapter.httpclient.ReviewServiceClient;

@Configuration
@EnableFeignClients(clients = {ReviewServiceClient.class})
public class FeignConfiguration {
}
