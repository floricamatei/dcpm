package ro.ilearn.dcpm.book.adapter.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.ilearn.dcpm.book.core.domain.Review;

import java.util.List;

@FeignClient(name = "review", fallbackFactory = ReviewServiceClientFallbackFactory.class)
public interface ReviewServiceClient {

    @GetMapping(path = "/api/v1/reviews/book/{bookId}")
    List<Review> getReviewsForBook(@PathVariable("bookId") Long bookId);
}
