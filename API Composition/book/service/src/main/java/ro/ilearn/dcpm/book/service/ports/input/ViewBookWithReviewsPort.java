package ro.ilearn.dcpm.book.service.ports.input;

import ro.ilearn.dcpm.book.service.domain.Book;

public interface ViewBookWithReviewsPort {
    Book getBookWithReviews(Long bookId);
}
