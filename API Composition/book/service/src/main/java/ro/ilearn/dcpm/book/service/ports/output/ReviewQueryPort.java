package ro.ilearn.dcpm.book.service.ports.output;

import ro.ilearn.dcpm.book.service.domain.Review;

import java.util.List;

public interface ReviewQueryPort {
    List<Review> getReviewsForBook(Long bookId);
}
