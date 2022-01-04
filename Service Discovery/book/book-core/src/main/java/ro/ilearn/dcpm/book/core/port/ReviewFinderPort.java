package ro.ilearn.dcpm.book.core.port;

import ro.ilearn.dcpm.book.core.domain.Review;

import java.util.List;

public interface ReviewFinderPort {
    List<Review> getReviewsForBook(Long bookId);
}
