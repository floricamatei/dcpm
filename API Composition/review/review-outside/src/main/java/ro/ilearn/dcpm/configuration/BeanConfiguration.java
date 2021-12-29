package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.review.core.port.ReviewFinderPort;
import ro.ilearn.dcpm.review.core.ViewReviewsForBook;

@Configuration
public class BeanConfiguration {

    @Bean
    public ViewReviewsForBook viewReviewsForBook(ReviewFinderPort reviewFinderPort) {
        return new ViewReviewsForBook(reviewFinderPort);
    }
}
