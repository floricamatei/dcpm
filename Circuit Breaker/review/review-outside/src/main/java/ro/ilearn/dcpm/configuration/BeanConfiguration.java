package ro.ilearn.dcpm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.review.core.ReviewQueryPort;
import ro.ilearn.dcpm.review.core.ViewReviewsForBook;

@Configuration
public class BeanConfiguration {

    @Bean
    public ViewReviewsForBook viewReviewsForBook(ReviewQueryPort reviewQueryPort) {
        return new ViewReviewsForBook(reviewQueryPort);
    }
}
