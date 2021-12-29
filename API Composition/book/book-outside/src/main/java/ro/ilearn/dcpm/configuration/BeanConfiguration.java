package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.book.core.port.BookFinderPort;
import ro.ilearn.dcpm.book.core.port.ReviewFinderPort;
import ro.ilearn.dcpm.book.core.ViewBookWithReviews;

@Configuration
public class BeanConfiguration {

    @Bean
    public ViewBookWithReviews viewBookWithReviews(BookFinderPort bookFinderPort, ReviewFinderPort reviewFinderPort) {
        return new ViewBookWithReviews(bookFinderPort, reviewFinderPort);
    }
}
