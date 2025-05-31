package ru.voroncov.cloudcomputing.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.voroncov.cloudcomputing.config.AppConfig;
import ru.voroncov.cloudcomputing.dto.response.product.ProductResponseDTO;
import ru.voroncov.cloudcomputing.dto.response.product.review.ProductReviewResponseDTO;
import ru.voroncov.cloudcomputing.dto.response.report.AvgRatingAndCountReviewDTO;
import ru.voroncov.cloudcomputing.dto.response.report.CompanyRatingReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.ProductRecommendReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.RatingByGenderReportDTO;
import ru.voroncov.cloudcomputing.dto.response.user.UserResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiClient {

    private final RestTemplate restTemplate;
    private final AppConfig appConfig;

    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return restTemplate.exchange(
                appConfig.getDataServiceUrl() + "/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }

    public ResponseEntity<List<ProductReviewResponseDTO>> getAllProductReviews() {
        return restTemplate.exchange(
                appConfig.getDataServiceUrl() + "/reviews",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }

    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return restTemplate.exchange(
                appConfig.getDataServiceUrl() + "/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }

    public ResponseEntity<List<AvgRatingAndCountReviewDTO>> getAvgRatingAndCountReviews() {
        return restTemplate.exchange(appConfig.getDataServiceUrl() +"/reports/get-avg-rating-and-count-reviews",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }

    public ResponseEntity<List<ProductRecommendReportDTO>> getRecommendPercentage() {
        return restTemplate.exchange(appConfig.getDataServiceUrl() +"/reports/get-recommend-percentage",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }

    public ResponseEntity<List<RatingByGenderReportDTO>> getRatingByGender() {
        return restTemplate.exchange(appConfig.getDataServiceUrl() +"/reports/get-avg-by-gender",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }

    public ResponseEntity<List<CompanyRatingReportDTO>> getCompanyRating() {
        return restTemplate.exchange(appConfig.getDataServiceUrl() +"/reports/get-company-rating",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }


}
