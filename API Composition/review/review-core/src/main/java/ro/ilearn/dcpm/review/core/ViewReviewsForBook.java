package ro.ilearn.dcpm.review.core;

import lombok.RequiredArgsConstructor;

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
