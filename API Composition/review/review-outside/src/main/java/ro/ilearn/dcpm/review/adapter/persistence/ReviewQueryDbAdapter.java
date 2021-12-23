package ro.ilearn.dcpm.review.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.review.core.Review;
import ro.ilearn.dcpm.review.core.ReviewQueryPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewQueryDbAdapter implements ReviewQueryPort {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public List<Review> findReviewsByBookId(Long bookId) {
        return reviewMapper.toReview(reviewRepository.findByBookId(bookId));
    }
}
