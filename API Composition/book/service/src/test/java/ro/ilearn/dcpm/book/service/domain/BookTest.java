package ro.ilearn.dcpm.book.service.domain;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BookTest {
    @Test
    void givenInvalidValue_throw() {
        // given
        Book book = Book.builder()
                .author("")
                .title("")
                .build();
        Exception exception = assertThrows(ConstraintViolationException.class, book::validateSelfBean);
        String expectedMessage = "title: must not be blank, author: must not be blank";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
