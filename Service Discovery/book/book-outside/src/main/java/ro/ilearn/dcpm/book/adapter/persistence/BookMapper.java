package ro.ilearn.dcpm.book.adapter.persistence;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.book.core.domain.Author;
import ro.ilearn.dcpm.book.core.domain.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookJpaEntity bookJpaEntity);

    Author toAuthor(AuthorJpaEntity authorJpaEntity);
}
