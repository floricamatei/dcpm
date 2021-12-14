package ro.ilearn.dcpm.book.output.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    private String title;
    private String author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookEntity)) return false;
        return id != null && id.equals(((BookEntity) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
