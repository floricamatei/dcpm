package ro.ilearn.dcpm.book.adapter.httpclient;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.book.core.Review;
import ro.ilearn.dcpm.book.core.ReviewQueryPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewQueryAdapter implements ReviewQueryPort {
    private final Logger logger = LoggerFactory.getLogger(ReviewQueryAdapter.class);
    private final ReviewClient reviewClient;


    @Override
    public List<Review> getReviewsForBook(Long bookId) {
        logger.info("Calling REST endpoint of review service ...");
        return reviewClient.getReviewsForBook(bookId);
    }
}
