package ru.voroncov.cloudcomputing.dto.response.report;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CompanyRatingReportDTO {

    private String companyProducer;
    private double averageRating;
    private long reviewCount;

}
