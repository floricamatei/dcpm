package ro.ilearn.dcpm.review.core.port;

import ro.ilearn.dcpm.review.core.domain.Review;

import java.util.List;

public interface ReviewFinderPort {
    List<Review> findReviewsByBookId(Long bookId);
}
