package ro.ilearn.dcpm.book.core.domain;

import lombok.Builder;
import lombok.Getter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class Book implements SelfBeanValidating<Book> {
    private Long id;
    @NotBlank
    private String title;
    @NotEmpty
    private List<Author> authors;
    private List<Review> reviews;

    public void addReviews(List<Review> reviewsToAdd) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        if (reviewsToAdd != null) {
            reviews.addAll(reviewsToAdd);
        }
    }
}
