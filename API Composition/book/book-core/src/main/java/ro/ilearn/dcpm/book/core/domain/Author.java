package ro.ilearn.dcpm.book.core.domain;

import lombok.Builder;
import lombok.Getter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class Author implements SelfBeanValidating<Author> {
    private Long id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
}
