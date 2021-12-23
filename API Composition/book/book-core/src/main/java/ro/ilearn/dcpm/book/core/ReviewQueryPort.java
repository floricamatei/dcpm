package ro.ilearn.dcpm.book.core;

import java.util.List;

public interface ReviewQueryPort {
    List<Review> getReviewsForBook(Long bookId);
}
