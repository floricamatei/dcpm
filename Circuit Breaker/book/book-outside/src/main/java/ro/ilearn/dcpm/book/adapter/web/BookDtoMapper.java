package ro.ilearn.dcpm.book.adapter.web;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ro.ilearn.dcpm.book.core.Author;
import ro.ilearn.dcpm.book.core.Book;

import java.util.Iterator;


@Mapper(componentModel = "spring")
public interface BookDtoMapper {

    @Mapping(target = "authors", ignore = true)
    BookDto toBookDto(Book book);

    @AfterMapping
    default void setAuthors(Book book, @MappingTarget BookDto bookDto) {
        if (book.getAuthors() != null && !book.getAuthors().isEmpty()) {
            StringBuilder authors = new StringBuilder();
            Iterator<Author> iterator = book.getAuthors().iterator();
            while (iterator.hasNext()) {
                Author author = iterator.next();
                authors.append(author.getFirstname()).append(" ").append(author.getLastname());
                if (iterator.hasNext()) {
                    authors.append(", ");
                }
            }
            bookDto.setAuthors(authors.toString());
        }
    }
}
