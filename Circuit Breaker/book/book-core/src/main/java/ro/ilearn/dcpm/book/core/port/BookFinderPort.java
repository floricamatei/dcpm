package ro.ilearn.dcpm.book.core.port;

import ro.ilearn.dcpm.book.core.domain.Book;

import java.util.Optional;

public interface BookFinderPort {
    Optional<Book> findBookById(Long bookId);
}
