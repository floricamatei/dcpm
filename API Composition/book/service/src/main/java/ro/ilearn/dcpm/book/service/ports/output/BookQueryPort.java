package ro.ilearn.dcpm.book.service.ports.output;

import ro.ilearn.dcpm.book.service.domain.Book;

import java.util.Optional;

public interface BookQueryPort {
    Optional<Book> findBookById(Long bookId);
}
