package ro.ilearn.dcpm.review.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.common.AppConstants;
import ro.ilearn.dcpm.review.core.domain.Review;
import ro.ilearn.dcpm.review.core.port.ReviewFinderPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewFinderJpaAdapter implements ReviewFinderPort {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    /**
     * @param bookId the identifier of the book
     * @return a list of reviews for book if found
     * @throws IllegalArgumentException – if bookId is null.
     */
    @Override
    public List<Review> findReviewsByBookId(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException(String.format(AppConstants.MUST_NOT_BE_NULL, "bookId"));
        }
        return reviewMapper.toReview(reviewRepository.findByBookId(bookId));
    }
}
