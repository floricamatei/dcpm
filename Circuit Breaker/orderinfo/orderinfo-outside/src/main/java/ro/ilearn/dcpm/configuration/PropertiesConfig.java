package ro.ilearn.dcpm.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.orderinfo.adapter.httpclient.DcpmProperties;

@Configuration
@EnableConfigurationProperties(DcpmProperties.class)
public class PropertiesConfig {

}
