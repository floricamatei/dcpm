package ro.ilearn.dcpm.review.adapter.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private Long id;
    private String message;
    private String writtenBy;
}
