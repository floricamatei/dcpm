package ro.ilearn.dcpm.review.adapter.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.review.core.ViewReviewsForBookPort;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final Logger logger = LoggerFactory.getLogger(ReviewController.class);
    private final ReviewDtoMapper reviewDtoMapper;
    private final ViewReviewsForBookPort viewReviewsForBookPort;

    @GetMapping(path = "/book/{bookId}")
    public List<ReviewDto> getReviewsForBook(@PathVariable Long bookId) {
        logger.info("Done ... returning reviews now");
        return reviewDtoMapper.toReviewForBook(viewReviewsForBookPort.execute(bookId));
    }
}