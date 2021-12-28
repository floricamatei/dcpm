package ro.ilearn.dcpm.review.adapter.persistence;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.review.core.Review;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toReview(ReviewJpaEntity reviewJpaEntity);

    List<Review> toReview(List<ReviewJpaEntity> reviewEntities);
}
