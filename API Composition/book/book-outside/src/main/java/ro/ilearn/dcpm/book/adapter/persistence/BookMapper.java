package ro.ilearn.dcpm.book.adapter.persistence;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.book.core.Author;
import ro.ilearn.dcpm.book.core.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookJpaEntity bookJpaEntity);

    Author toAuthor(AuthorJpaEntity authorJpaEntity);
}
