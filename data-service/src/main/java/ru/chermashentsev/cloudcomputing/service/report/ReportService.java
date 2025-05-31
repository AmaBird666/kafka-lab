package ru.voroncov.cloudcomputing.service.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voroncov.cloudcomputing.dto.response.report.AvgRatingAndCountReviewDTO;
import ru.voroncov.cloudcomputing.dto.response.report.CompanyRatingReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.ProductRecommendReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.RatingByGenderReportDTO;
import ru.voroncov.cloudcomputing.repository.ProductRepository;
import ru.voroncov.cloudcomputing.repository.ProductReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ProductRepository productRepository;
    private final ProductReviewRepository productReviewRepository;


    public List<AvgRatingAndCountReviewDTO> getAvgRatingAndCountReview() {
        return productRepository.findProductRatingReport();
    }

    public List<ProductRecommendReportDTO> getProductRecommendReport() {
        return productReviewRepository.findRecommendPercentageByProduct();
    }

    public List<RatingByGenderReportDTO> getRatingByGenderReport() {
        return productReviewRepository.findAverageRatingByUserGender();
    }

    public List<CompanyRatingReportDTO> getCompanyRatingReport() {
        return productReviewRepository.findCompanyRatingReport();
    }

}
