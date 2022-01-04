package ro.ilearn.dcpm.orderinfo.adapter.httpclient.book;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class BookServiceClientFallbackFactory implements FallbackFactory<BookServiceClientFallbackWithFactory> {
    @Override
    public BookServiceClientFallbackWithFactory create(Throwable cause) {
        return new BookServiceClientFallbackWithFactory(cause);
    }
}
