package ro.ilearn.dcpm.book.output.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Getter
@Setter
public class ReviewEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    @Column(name = "book_id")
    private Long bookId;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewEntity)) return false;
        return id != null && id.equals(((ReviewEntity) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}