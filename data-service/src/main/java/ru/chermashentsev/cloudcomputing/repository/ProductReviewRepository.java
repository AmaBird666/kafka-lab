package ru.voroncov.cloudcomputing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.voroncov.cloudcomputing.dto.response.report.CompanyRatingReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.ProductRecommendReportDTO;
import ru.voroncov.cloudcomputing.dto.response.report.RatingByGenderReportDTO;
import ru.voroncov.cloudcomputing.entity.ProductReview;

import java.util.List;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

    @Query("""
      select new ru.voroncov.cloudcomputing.dto.response.report.ProductRecommendReportDTO(
        p.id,
        p.description,
        (sum(case when r.recommendToFriend = true then 1 else 0 end) * 100.0 / count(r))
      )
      from ProductReview r
      join r.product p
      group by p.id
    """)
    List<ProductRecommendReportDTO> findRecommendPercentageByProduct();

    @Query("""
      select new ru.voroncov.cloudcomputing.dto.response.report.RatingByGenderReportDTO(
        u.gender,
        avg(r.rating)
      )
      from ProductReview r
      join r.user u
      group by u.gender
    """)
    List<RatingByGenderReportDTO> findAverageRatingByUserGender();

    @Query("""
      select new ru.voroncov.cloudcomputing.dto.response.report.CompanyRatingReportDTO(
        p.companyProducer,
        avg(r.rating),
        count(r)
      )
      from ProductReview r
      join r.product p
      group by p.companyProducer
    """)
    List<CompanyRatingReportDTO> findCompanyRatingReport();
}
