package ru.voroncov.cloudcomputing.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.voroncov.cloudcomputing.client.ApiClient;
import ru.voroncov.cloudcomputing.dto.response.report.AvgRatingAndCountReviewDTO;
import ru.voroncov.cloudcomputing.dto.response.report.CompanyRatingReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.ProductRecommendReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.RatingByGenderReportDTO;

import java.util.List;

@RestController
@RequestMapping("api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ApiClient apiClient;


    @GetMapping("get-avg-rating-and-count-reviews")
    public ResponseEntity<List<AvgRatingAndCountReviewDTO>> getAvgRatingAndCountReviews() {
        return apiClient.getAvgRatingAndCountReviews();
    }

    @GetMapping("get-recommend-percentage")
    public ResponseEntity<List<ProductRecommendReportDTO>> getRecommendPercentage() {
        return apiClient.getRecommendPercentage();
    }

    @GetMapping("get-avg-by-gender")
    public ResponseEntity<List<RatingByGenderReportDTO>> getRatingByGender() {
        return apiClient.getRatingByGender();
    }

    @GetMapping("get-company-rating")
    public ResponseEntity<List<CompanyRatingReportDTO>> getCompanyRating() {
        return apiClient.getCompanyRating();
    }

}
