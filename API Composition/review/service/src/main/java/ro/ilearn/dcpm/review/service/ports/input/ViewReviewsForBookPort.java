package ro.ilearn.dcpm.review.service.ports.input;

import ro.ilearn.dcpm.review.service.domain.Review;

import java.util.List;

public interface ViewReviewsForBookPort {
    List<Review> execute(Long bookId);
}
