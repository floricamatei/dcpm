package ro.ilearn.dcpm.book.service.domain;

import lombok.Getter;
import lombok.Setter;
import ro.ilearn.dcpm.common.SelfValidating;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class Book implements SelfValidating<Book> {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    private List<Review> reviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return id != null && id.equals(((Book) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
