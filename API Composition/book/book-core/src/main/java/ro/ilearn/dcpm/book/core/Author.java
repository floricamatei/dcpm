package ro.ilearn.dcpm.book.core;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.ilearn.dcpm.common.SelfBeanValidating;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class Author implements SelfBeanValidating<Author> {
    private Long id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
}
