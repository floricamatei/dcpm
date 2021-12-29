package ro.ilearn.dcpm.book.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
    private String message;
    private String writtenBy;
}