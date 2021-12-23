package ro.ilearn.dcpm.book.adapter.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Getter
@Setter
public class AuthorJpaEntity {

    @Id
    @SequenceGenerator(name = "author_seq_generator", sequenceName = "author_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq_generator")
    private Long id;
    private String firstname;
    private String lastname;
    @Version
    private int version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorJpaEntity)) return false;
        return id != null && id.equals(((AuthorJpaEntity) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
