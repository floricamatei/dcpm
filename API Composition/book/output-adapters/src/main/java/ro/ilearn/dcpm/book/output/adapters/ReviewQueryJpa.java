package ro.ilearn.dcpm.book.output.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.book.output.jpa.ReviewRepository;
import ro.ilearn.dcpm.book.output.mappers.ReviewMapper;
import ro.ilearn.dcpm.book.service.domain.Review;
import ro.ilearn.dcpm.book.service.ports.output.ReviewQueryPort;

import java.util.List;

@Component
@ConditionalOnProperty(name = "book.review.restapi", havingValue = "off")
@RequiredArgsConstructor
public class ReviewQueryJpa implements ReviewQueryPort {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public List<Review> getReviewsForBook(Long bookId) {
        return reviewMapper.toReview(reviewRepository.findByBookId(bookId));
    }
}
