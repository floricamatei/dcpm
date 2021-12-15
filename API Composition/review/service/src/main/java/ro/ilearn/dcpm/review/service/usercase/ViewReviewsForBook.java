package ro.ilearn.dcpm.review.service.usercase;

import lombok.RequiredArgsConstructor;
import ro.ilearn.dcpm.review.service.domain.Review;
import ro.ilearn.dcpm.review.service.ports.output.ReviewQueryPort;
import ro.ilearn.dcpm.review.service.ports.input.ViewReviewsForBookPort;

import java.util.List;

@RequiredArgsConstructor
public class ViewReviewsForBook implements ViewReviewsForBookPort {
    private final ReviewQueryPort reviewQueryPort;

    @Override
    public List<Review> execute(Long bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException();
        }
        return reviewQueryPort.findReviewsByBookId(bookId);
    }
}
