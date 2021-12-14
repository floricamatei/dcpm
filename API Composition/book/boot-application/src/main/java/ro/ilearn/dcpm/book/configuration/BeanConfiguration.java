package ro.ilearn.dcpm.book.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.book.service.ports.output.BookQueryPort;
import ro.ilearn.dcpm.book.service.ports.output.ReviewQueryPort;
import ro.ilearn.dcpm.book.service.usercase.ViewBookWithReviews;

@Configuration
public class BeanConfiguration {

    @Bean
    public ViewBookWithReviews viewBookWithReviews(BookQueryPort bookQueryPort, ReviewQueryPort reviewQueryPort) {
        return new ViewBookWithReviews(bookQueryPort, reviewQueryPort);
    }
}
