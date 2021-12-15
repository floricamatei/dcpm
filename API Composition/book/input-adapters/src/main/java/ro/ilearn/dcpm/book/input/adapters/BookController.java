package ro.ilearn.dcpm.book.input.adapters;

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

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the book",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookViewResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
    })
    @GetMapping(path = "/{bookId}")
    public BookViewResponse getBook(@PathVariable Long bookId) {
        logger.info("Done ... returning book now");
        return bookViewResponseMapper.toBookViewResponse(viewBookWithReviewsPort.execute(bookId));
    }
}