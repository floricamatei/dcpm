package ro.ilearn.dcpm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Order Info microservice",
                version = "1",
                description = "Order Info REST APIs"
        )
)
public class OrderInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderInfoApplication.class, args);
    }

}
