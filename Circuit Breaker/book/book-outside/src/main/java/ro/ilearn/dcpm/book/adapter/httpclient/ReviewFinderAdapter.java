package ro.ilearn.dcpm.book.adapter.httpclient;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ilearn.dcpm.book.core.domain.Review;
import ro.ilearn.dcpm.book.core.port.ReviewFinderPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewFinderAdapter implements ReviewFinderPort {
    private final Logger logger = LoggerFactory.getLogger(ReviewFinderAdapter.class);
    private final ReviewServiceClient reviewServiceClient;

    @Override
    public List<Review> getReviewsForBook(Long bookId) {
        logger.info("Calling REST endpoint of review service ...");
        return reviewServiceClient.getReviewsForBook(bookId);
    }
}
