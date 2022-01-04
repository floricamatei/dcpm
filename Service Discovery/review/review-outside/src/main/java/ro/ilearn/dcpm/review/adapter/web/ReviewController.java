package ro.ilearn.dcpm.review.adapter.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.review.core.port.ViewReviewsForBookPort;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final Logger logger = LoggerFactory.getLogger(ReviewController.class);
    private final ReviewDtoMapper reviewDtoMapper;
    private final ViewReviewsForBookPort viewReviewsForBookPort;

    @Operation(summary = "Get reviews of the book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewDto.class)) })
    })
    @GetMapping(path = "/book/{bookId}")
    public List<ReviewDto> getReviewsForBook(@PathVariable Long bookId) throws InterruptedException {
        /* if (logger.isInfoEnabled()) {
            logger.info(String.format("Sleeping for 5000ms before returning reviews for book with id %d",
                    bookId));
        }
        Thread.sleep(5000); */
        logger.info("Done ... returning reviews now");
        return reviewDtoMapper.toReviewDto(viewReviewsForBookPort.execute(bookId));
    }
}