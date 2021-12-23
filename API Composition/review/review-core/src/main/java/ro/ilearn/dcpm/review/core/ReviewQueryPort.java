package ro.ilearn.dcpm.review.core;

import java.util.List;

public interface ReviewQueryPort {
    List<Review> findReviewsByBookId(Long bookId);
}
