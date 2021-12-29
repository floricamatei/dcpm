package ro.ilearn.dcpm.orderinfo.core.port;

import ro.ilearn.dcpm.orderinfo.core.domain.Book;

public interface BookFinderPort {
    Book getBook(Long bookId);
}
