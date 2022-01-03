package ro.ilearn.dcpm.orderinfo.adapter.httpclient.book;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.orderinfo.core.domain.Book;
import ro.ilearn.dcpm.orderinfo.core.port.BookFinderPort;


@Component
@RequiredArgsConstructor
public class BookFinderAdapter implements BookFinderPort {
    private final Logger logger = LoggerFactory.getLogger(BookFinderAdapter.class);
    private final BookServiceClient bookServiceClient;


    @Override
    public Book getBook(Long bookId) {
        logger.info("Calling REST endpoint of book service ...");
        return bookServiceClient.getBook(bookId);
    }
}
