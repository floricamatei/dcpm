package ro.ilearn.dcpm.book.input.mappers;

import org.mapstruct.Mapper;
import ro.ilearn.dcpm.book.input.adapters.dto.BookViewResponse;
import ro.ilearn.dcpm.book.service.domain.Book;

@Mapper(componentModel = "spring", uses = {ReviewForBookMapper.class})
public interface BookViewResponseMapper {
    BookViewResponse toBookViewResponse(Book book);
}
