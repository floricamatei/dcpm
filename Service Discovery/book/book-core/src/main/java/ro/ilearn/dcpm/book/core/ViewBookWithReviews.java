package ro.ilearn.dcpm.book.core;

import lombok.RequiredArgsConstructor;
import ro.ilearn.dcpm.book.core.domain.Book;
import ro.ilearn.dcpm.book.core.port.BookFinderPort;
import ro.ilearn.dcpm.book.core.port.ReviewFinderPort;
import ro.ilearn.dcpm.book.core.port.ViewBookWithReviewsPort;
import ro.ilearn.dcpm.common.AppConstants;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class ViewBookWithReviews implements ViewBookWithReviewsPort {
    private final BookFinderPort bookFinderPort;
    private final ReviewFinderPort reviewFinderPort;

    /**
     * @param bookId the identifier of the book
     * @return the book with the given identifier or throw NoSuchElementException if none found.
     * @throws IllegalArgumentException – if bookId is null.
     * @throws NoSuchElementException   - if book not found by given identifier
     */
    @Override
    public Book execute(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "bookId"));
        }
        Book book = bookFinderPort.findBookById(bookId).orElseThrow(() ->
                new NoSuchElementException(String.format(AppConstants.NOT_SUCH_ELEMENT, "Book", bookId))
        );
        book.addReviews(reviewFinderPort.getReviewsForBook(bookId));
        return book;
    }
}
