package ru.voroncov.cloudcomputing.api.report;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.voroncov.cloudcomputing.dto.response.report.AvgRatingAndCountReviewDTO;
import ru.voroncov.cloudcomputing.dto.response.report.CompanyRatingReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.ProductRecommendReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.RatingByGenderReportDTO;
import ru.voroncov.cloudcomputing.service.report.ReportService;

import java.util.List;

@RestController
@RequestMapping("reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("get-avg-rating-and-count-reviews")
    public ResponseEntity<List<AvgRatingAndCountReviewDTO>> getAvgRatingAndCountReview() {
        return ResponseEntity.ok(reportService.getAvgRatingAndCountReview());
    }

    @GetMapping("get-recommend-percentage")
    public ResponseEntity<List<ProductRecommendReportDTO>> getRecommendPercentage() {
        return ResponseEntity.ok(reportService.getProductRecommendReport());
    }

    @GetMapping("get-avg-by-gender")
    public ResponseEntity<List<RatingByGenderReportDTO>> getAvgByGender() {
        return ResponseEntity.ok(reportService.getRatingByGenderReport());
    }

    @GetMapping("get-company-rating")
    public ResponseEntity<List<CompanyRatingReportDTO>> getCompanyRating() {
        return ResponseEntity.ok(reportService.getCompanyRatingReport());
    }

}
