package ro.ilearn.dcpm.book.adapter.httpclient;

import lombok.extern.slf4j.Slf4j;
import ro.ilearn.dcpm.book.core.domain.Review;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReviewServiceClientFallbackWithFactory implements ReviewServiceClient {
    private Throwable cause;

    public ReviewServiceClientFallbackWithFactory(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public List<Review> getReviewsForBook(Long bookId) {
        log.info(cause.getMessage(), cause);
        return new ArrayList<>();
    }

}
