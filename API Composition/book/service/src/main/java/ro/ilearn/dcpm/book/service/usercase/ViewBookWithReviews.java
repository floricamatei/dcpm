package ro.ilearn.dcpm.book.service.usercase;

import lombok.RequiredArgsConstructor;
import ro.ilearn.dcpm.book.service.domain.Book;
import ro.ilearn.dcpm.book.service.ports.input.ViewBookWithReviewsPort;
import ro.ilearn.dcpm.book.service.ports.output.BookQueryPort;
import ro.ilearn.dcpm.book.service.ports.output.ReviewQueryPort;

import java.util.Optional;

@RequiredArgsConstructor
public class ViewBookWithReviews implements ViewBookWithReviewsPort {
    private final BookQueryPort bookQueryPort;
    private final ReviewQueryPort reviewQueryPort;

    @Override
    public Book execute(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException();
        }
        Optional<Book> value = bookQueryPort.findBookById(bookId);
        if (value.isPresent()) {
            Book book = value.get();
            book.setReviews(reviewQueryPort.getReviewsForBook(bookId));
        }
        return value.orElse(new Book());
    }
}
