package ro.ilearn.dcpm.book.adapter.httpclient;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ReviewServiceClientFallbackFactory implements FallbackFactory<ReviewServiceClientFallbackWithFactory> {
    @Override
    public ReviewServiceClientFallbackWithFactory create(Throwable cause) {
        return new ReviewServiceClientFallbackWithFactory(cause);
    }
}
