package ro.ilearn.dcpm.review.service.domain;

import lombok.Builder;
import lombok.Getter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class Review implements SelfBeanValidating<Review> {
    private Long id;
    @NotBlank
    private String message;
    @NotNull
    private Long bookId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        return id != null && id.equals(((Review) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}