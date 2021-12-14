package ro.ilearn.dcpm.book.output.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.book.output.jpa.BookEntity;
import ro.ilearn.dcpm.book.output.jpa.BookRepository;
import ro.ilearn.dcpm.book.output.mappers.BookMapper;
import ro.ilearn.dcpm.book.service.domain.Book;
import ro.ilearn.dcpm.book.service.ports.output.BookQueryPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookQueryJpa implements BookQueryPort {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Optional<Book> findBookById(Long bookId) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(bookId);
        return optionalBookEntity.map(bookMapper::toBook);
    }
}
