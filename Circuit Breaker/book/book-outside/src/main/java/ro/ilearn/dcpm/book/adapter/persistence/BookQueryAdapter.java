package ro.ilearn.dcpm.book.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.book.core.Book;
import ro.ilearn.dcpm.book.core.BookQueryPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookQueryAdapter implements BookQueryPort {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Optional<Book> findBookById(Long bookId) {
        Optional<BookJpaEntity> optionalBookJpaEntity= bookRepository.findById(bookId);
        return optionalBookJpaEntity.map(bookMapper::toBook);
    }
}
