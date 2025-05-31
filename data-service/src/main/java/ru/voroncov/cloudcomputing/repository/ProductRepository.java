package ru.voroncov.cloudcomputing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.voroncov.cloudcomputing.dto.response.report.AvgRatingAndCountReviewDTO;
import ru.voroncov.cloudcomputing.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
              select new ru.voroncov.cloudcomputing.dto.response.report.AvgRatingAndCountReviewDTO(
                  p.id,
                  p.description,
                  avg(r.rating),
                  count(r)
              )
              from ProductReview r
              join r.product p
              group by p.id
            """)
    List<AvgRatingAndCountReviewDTO> findProductRatingReport();

}
