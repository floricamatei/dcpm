package ro.ilearn.dcpm.book.output.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ro.ilearn.dcpm.book.output.adapters.http.DcpmProperties;
import ro.ilearn.dcpm.book.service.domain.Review;
import ro.ilearn.dcpm.book.service.ports.output.ReviewQueryPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ConditionalOnProperty(name = "book.review.restapi", havingValue = "on", matchIfMissing = true)
public class ReviewQueryHttp implements ReviewQueryPort {
    private final Logger logger = LoggerFactory.getLogger(ReviewQueryHttp.class);
    private final WebClient webClient;
    private final ObjectMapper mapper;
    private final DcpmProperties dcpmProperties;

    public ReviewQueryHttp(
            ObjectMapper mapper,
            DcpmProperties dcpmProperties,
            WebClient.Builder webClientBuilder) {
        this.mapper = mapper;
        this.dcpmProperties = dcpmProperties;
        webClient = webClientBuilder.baseUrl(dcpmProperties.getReviewApiHost()).build();
    }

    @Override
    public List<Review> getReviewsForBook(Long bookId) {
        logger.info("Calling REST endpoint of review service ...");
        Mono<Object[]> response = webClient.get()
                .uri(dcpmProperties.getReviewBookByIdPath(), bookId)
                .retrieve()
                .bodyToMono(Object[].class);
        Object[] reviews = response.block();
        if (reviews != null) {
            return Arrays.stream(reviews)
                    .map(object -> mapper.convertValue(object, Review.class))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
