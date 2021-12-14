package ro.ilearn.dcpm.review.output.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.review.output.jpa.ReviewRepository;
import ro.ilearn.dcpm.review.output.mappers.ReviewMapper;
import ro.ilearn.dcpm.review.service.domain.Review;
import ro.ilearn.dcpm.review.service.ports.output.ReviewQueryPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewQueryDbSqlAdapter implements ReviewQueryPort {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public List<Review> findReviewsByBookId(Long bookId) {
        return reviewMapper.toReview(reviewRepository.findByBookId(bookId));
    }
}
