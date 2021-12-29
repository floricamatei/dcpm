package ro.ilearn.dcpm.book.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.book.core.domain.Book;
import ro.ilearn.dcpm.book.core.port.BookFinderPort;
import ro.ilearn.dcpm.common.AppConstants;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookFinderJpaAdapter implements BookFinderPort {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    /**
     * @param bookId the identifier of the book
     * @return the book with the given identifier or Optional#empty() if none found.
     * @throws IllegalArgumentException – if bookId is null.
     */
    @Override
    public Optional<Book> findBookById(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "bookId"));
        }
        Optional<BookJpaEntity> optionalBookJpaEntity = bookRepository.findById(bookId);
        return optionalBookJpaEntity.map(bookMapper::toBook);
    }
}
