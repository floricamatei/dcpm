package ro.ilearn.dcpm.orderinfo.adapter.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.ilearn.dcpm.orderinfo.core.Book;

@FeignClient(value = "book-client", url = "${dcpm.book-api-host}/api/v1/books")
public interface BookClient {
    @GetMapping(path = "/{bookId}")
    Book getBook(@PathVariable("bookId") Long bookId);
}
