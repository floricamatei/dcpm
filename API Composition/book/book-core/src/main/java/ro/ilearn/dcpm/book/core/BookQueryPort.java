package ro.ilearn.dcpm.book.core;

import java.util.Optional;

public interface BookQueryPort {
    Optional<Book> findBookById(Long bookId);
}
