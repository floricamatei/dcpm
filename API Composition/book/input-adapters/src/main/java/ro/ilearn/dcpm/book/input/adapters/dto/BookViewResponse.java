package ro.ilearn.dcpm.book.input.adapters.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookViewResponse {
    private Long id;
    private String title;
    private String author;
    private List<ReviewForBook> reviews;
}
