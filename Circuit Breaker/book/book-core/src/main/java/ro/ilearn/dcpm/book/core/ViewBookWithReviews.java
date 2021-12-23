package ro.ilearn.dcpm.book.core;

import lombok.RequiredArgsConstructor;

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
        return value.orElse(Book.builder().build());
    }
}
