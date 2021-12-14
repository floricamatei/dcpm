package ro.ilearn.dcpm.book.output.mappers;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.book.output.jpa.BookEntity;
import ro.ilearn.dcpm.book.service.domain.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookEntity bookEntity);
}
