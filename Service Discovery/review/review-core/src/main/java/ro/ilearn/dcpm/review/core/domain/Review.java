package ro.ilearn.dcpm.review.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class Review implements SelfBeanValidating<Review> {
    private Long id;
    @NotBlank
    private String message;
    @NotNull
    private Long bookId;
    @NotBlank
    private String writtenBy;
}