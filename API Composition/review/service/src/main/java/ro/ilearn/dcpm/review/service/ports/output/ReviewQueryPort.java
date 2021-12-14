package ro.ilearn.dcpm.review.service.ports.output;

import ro.ilearn.dcpm.review.service.domain.Review;

import java.util.List;

public interface ReviewQueryPort {
    List<Review> findReviewsByBookId(Long bookId);
}
