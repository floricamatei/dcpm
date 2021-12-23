package ro.ilearn.dcpm.book.core;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
    private Long id;
    private String message;
    private String writtenBy;
}