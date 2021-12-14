package ro.ilearn.dcpm.book.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.book.output.adapters.http.DcpmProperties;


@Configuration
@EnableConfigurationProperties(DcpmProperties.class)
public class PropertiesConfig {

}
