package ro.ilearn.dcpm.review.output.mappers;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.review.output.jpa.ReviewEntity;
import ro.ilearn.dcpm.review.service.domain.Review;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toReview(ReviewEntity reviewEntity);

    List<Review> toReview(List<ReviewEntity> reviewEntities);
}
