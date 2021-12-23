package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.book.core.BookQueryPort;
import ro.ilearn.dcpm.book.core.ReviewQueryPort;
import ro.ilearn.dcpm.book.core.ViewBookWithReviews;


@Configuration
public class BeanConfiguration {

    @Bean
    public ViewBookWithReviews viewBookWithReviews(BookQueryPort bookQueryPort, ReviewQueryPort reviewQueryPort) {
        return new ViewBookWithReviews(bookQueryPort, reviewQueryPort);
    }
}
