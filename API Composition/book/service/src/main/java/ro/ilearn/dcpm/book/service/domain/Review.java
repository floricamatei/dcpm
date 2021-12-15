package ro.ilearn.dcpm.book.service.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
    private Long id;
    private String message;

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