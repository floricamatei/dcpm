package ro.ilearn.dcpm.review.core;

import lombok.RequiredArgsConstructor;
import ro.ilearn.dcpm.common.AppConstants;
import ro.ilearn.dcpm.review.core.domain.Review;
import ro.ilearn.dcpm.review.core.port.ReviewFinderPort;
import ro.ilearn.dcpm.review.core.port.ViewReviewsForBookPort;

import java.util.List;

@RequiredArgsConstructor
public class ViewReviewsForBook implements ViewReviewsForBookPort {
    private final ReviewFinderPort reviewFinderPort;

    /**
     * @param bookId the identifier of the book
     * @return a list of reviews for book if found
     * @throws IllegalArgumentException – if bookId is null.
     */
    @Override
    public List<Review> execute(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "bookId"));
        }
        return reviewFinderPort.findReviewsByBookId(bookId);
    }
}
