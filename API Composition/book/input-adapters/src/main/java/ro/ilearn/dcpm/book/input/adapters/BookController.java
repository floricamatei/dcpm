package ro.ilearn.dcpm.book.input.adapters;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.book.input.adapters.dto.BookViewResponse;
import ro.ilearn.dcpm.book.input.mappers.BookViewResponseMapper;
import ro.ilearn.dcpm.book.service.ports.input.ViewBookWithReviewsPort;

@RestController
@RequestMapping(path = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final ViewBookWithReviewsPort viewBookWithReviewsPort;
    private final BookViewResponseMapper bookViewResponseMapper;


    @GetMapping(path = "/{bookId}")
    public BookViewResponse getBook(@PathVariable Long bookId) {
        logger.info("Done ... returning book now");
        return bookViewResponseMapper.toBookViewResponse(viewBookWithReviewsPort.getBookWithReviews(bookId));
    }
}