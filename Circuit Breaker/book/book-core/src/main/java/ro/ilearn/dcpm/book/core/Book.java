package ro.ilearn.dcpm.book.core;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Builder
public class Book implements SelfBeanValidating<Book> {
    private Long id;
    @NotBlank
    private String title;
    @NotEmpty
    private List<Author> authors;
    private List<Review> reviews;
}
