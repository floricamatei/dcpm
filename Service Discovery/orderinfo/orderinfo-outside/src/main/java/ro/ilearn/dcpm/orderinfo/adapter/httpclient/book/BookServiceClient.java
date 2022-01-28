package ro.ilearn.dcpm.orderinfo.adapter.httpclient.book;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.ilearn.dcpm.orderinfo.core.domain.Book;

@FeignClient(name = "book", fallback = BookServiceClientFallback.class)
public interface BookServiceClient {
    @GetMapping(path = "/api/v1/books/{bookId}")
    Book getBook(@PathVariable("bookId") Long bookId);
}
