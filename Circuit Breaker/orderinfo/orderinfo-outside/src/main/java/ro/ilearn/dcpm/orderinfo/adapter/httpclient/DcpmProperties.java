package ro.ilearn.dcpm.orderinfo.adapter.httpclient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(value = "dcpm", ignoreUnknownFields = false)
public class DcpmProperties {
    private final String bookApiPath;
    private final String orderApiPath;
    private final String inventoryApiPath;
}
