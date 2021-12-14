package ro.ilearn.dcpm.review.controller.adapters;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.review.controller.adapters.dto.ReviewForBook;
import ro.ilearn.dcpm.review.controller.mappers.ReviewForBookMapper;
import ro.ilearn.dcpm.review.service.ports.input.ViewReviewsForBookPort;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final Logger logger = LoggerFactory.getLogger(ReviewController.class);
    private final ViewReviewsForBookPort viewReviewsForBookPort;
    private final ReviewForBookMapper reviewForBookMapper;


    @GetMapping(path = "/book/{bookId}")
    public List<ReviewForBook> getReviewsForBook(@PathVariable Long bookId) {
        logger.info("Done ... returning reviews now");
        return reviewForBookMapper.toReviewForBook(viewReviewsForBookPort.getReviewsForBook(bookId));
    }
}