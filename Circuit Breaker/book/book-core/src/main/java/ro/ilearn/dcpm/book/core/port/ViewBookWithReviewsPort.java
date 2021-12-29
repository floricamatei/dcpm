package ro.ilearn.dcpm.book.core.port;

import ro.ilearn.dcpm.book.core.domain.Book;

public interface ViewBookWithReviewsPort {
    Book execute(Long bookId);
}
