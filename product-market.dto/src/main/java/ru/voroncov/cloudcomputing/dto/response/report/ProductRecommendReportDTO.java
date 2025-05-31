package ru.voroncov.cloudcomputing.dto.response.report;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductRecommendReportDTO {

    private long productId;
    private String description;
    private double recommendPercentage;

}
