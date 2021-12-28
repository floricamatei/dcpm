package ro.ilearn.dcpm.orderinfo.adapter.httpclient;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.orderinfo.core.Book;
import ro.ilearn.dcpm.orderinfo.core.BookQueryPort;


@Component
@RequiredArgsConstructor
public class BookQueryAdapter implements BookQueryPort {
    private final Logger logger = LoggerFactory.getLogger(BookQueryAdapter.class);
    private final BookClient bookClient;


    @Override
    public Book getBook(Long bookId) {
        logger.info("Calling REST endpoint of book service ...");
        return bookClient.getBook(bookId);
    }
}
