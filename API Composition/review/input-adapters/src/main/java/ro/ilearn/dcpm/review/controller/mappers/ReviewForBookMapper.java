package ro.ilearn.dcpm.review.controller.mappers;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.review.controller.adapters.dto.ReviewForBook;
import ro.ilearn.dcpm.review.service.domain.Review;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewForBookMapper {

    ReviewForBook toReviewForBook(Review review);

    List<ReviewForBook> toReviewForBook(List<Review> review);
}
