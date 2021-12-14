package ro.ilearn.dcpm.book.input.mappers;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.book.input.adapters.dto.ReviewForBook;
import ro.ilearn.dcpm.book.service.domain.Review;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewForBookMapper {

    ReviewForBook toReviewForBook(Review review);

    List<ReviewForBook> toReviewForBook(List<Review> review);
}
