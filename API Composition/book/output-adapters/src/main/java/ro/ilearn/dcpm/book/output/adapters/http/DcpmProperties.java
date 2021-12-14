package ro.ilearn.dcpm.book.output.adapters.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(value = "dcpm", ignoreUnknownFields = false)
public class DcpmProperties {
    private final String reviewApiHost;
    private final String reviewPath;
    private final String reviewBookByIdPath;

}
