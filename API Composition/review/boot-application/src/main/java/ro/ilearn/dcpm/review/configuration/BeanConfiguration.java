package ro.ilearn.dcpm.review.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ilearn.dcpm.review.service.ports.output.ReviewQueryPort;
import ro.ilearn.dcpm.review.service.usercase.ViewReviewsForBook;

@Configuration
public class BeanConfiguration {

    @Bean
    public ViewReviewsForBook viewReviewsForBook(ReviewQueryPort reviewQueryPort) {
        return new ViewReviewsForBook(reviewQueryPort);
    }
}
