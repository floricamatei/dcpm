package ro.ilearn.dcpm.orderinfo.adapter.httpclient.book;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.ilearn.dcpm.orderinfo.core.domain.Book;

@FeignClient(name = "book", url = "${dcpm.book-api-path}")
public interface BookServiceClient {
    @GetMapping(path = "/{bookId}")
    Book getBook(@PathVariable("bookId") Long bookId);
}
