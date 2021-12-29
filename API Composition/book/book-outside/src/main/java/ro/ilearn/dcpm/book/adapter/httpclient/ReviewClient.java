package ro.ilearn.dcpm.book.adapter.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.ilearn.dcpm.book.core.domain.Review;

import java.util.List;

@FeignClient(value = "review-client",url = "${dcpm.review-api-host}${dcpm.review-path}")
public interface ReviewClient {
    @GetMapping(path = "/book/{bookId}")
    List<Review> getReviewsForBook(@PathVariable("bookId") Long bookId);
}
