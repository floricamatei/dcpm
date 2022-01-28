package ro.ilearn.dcpm.orderinfo.adapter.httpclient.book;

import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.orderinfo.core.domain.Book;

@Component
public class BookServiceClientFallback implements BookServiceClient {
    @Override
    public Book getBook(Long bookId) {
        return Book.builder().build();
    }
}
