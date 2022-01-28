package ro.ilearn.dcpm.orderinfo.adapter.httpclient.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.orderinfo.core.domain.Book;
import ro.ilearn.dcpm.orderinfo.core.port.BookFinderPort;


@Component
@RequiredArgsConstructor
@Slf4j
public class BookFinderAdapter implements BookFinderPort {
    private final BookServiceClient bookServiceClient;

    @Override
    public Book getBook(Long bookId) {
        log.info("Calling REST endpoint of book service ...");
        return bookServiceClient.getBook(bookId);
    }
}
