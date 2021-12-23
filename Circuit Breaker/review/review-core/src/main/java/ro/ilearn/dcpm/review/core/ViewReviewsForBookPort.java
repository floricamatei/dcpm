package ro.ilearn.dcpm.review.core;

import java.util.List;

public interface ViewReviewsForBookPort {
    List<Review> execute(Long bookId);
}
