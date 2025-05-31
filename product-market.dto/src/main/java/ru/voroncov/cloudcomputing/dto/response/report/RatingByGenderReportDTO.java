package ru.voroncov.cloudcomputing.dto.response.report;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RatingByGenderReportDTO {
    private String gender;
    private double averageRating;
}
