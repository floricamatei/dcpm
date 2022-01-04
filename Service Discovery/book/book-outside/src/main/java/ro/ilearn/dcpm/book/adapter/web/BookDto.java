package ro.ilearn.dcpm.book.adapter.web;

import lombok.Getter;
import lombok.Setter;
import ro.ilearn.dcpm.book.core.domain.Review;

import java.util.List;

@Getter
@Setter
public class BookDto {
    private Long id;
    private String title;
    private String authors;
    private List<Review> reviews;
}
