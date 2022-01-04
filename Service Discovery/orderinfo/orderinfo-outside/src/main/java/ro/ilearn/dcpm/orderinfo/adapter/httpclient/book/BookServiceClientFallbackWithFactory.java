package ro.ilearn.dcpm.orderinfo.adapter.httpclient.book;

import lombok.extern.slf4j.Slf4j;
import ro.ilearn.dcpm.orderinfo.core.domain.Book;

@Slf4j
public class BookServiceClientFallbackWithFactory implements BookServiceClient {
    private final Throwable cause;

    public BookServiceClientFallbackWithFactory(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public Book getBook(Long bookId) {
        log.info(cause.getMessage(), cause);
        return Book.builder().build();
    }

}
