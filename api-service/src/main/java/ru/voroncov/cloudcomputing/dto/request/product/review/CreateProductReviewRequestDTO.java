package ru.voroncov.cloudcomputing.dto.request.product.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import static ru.voroncov.cloudcomputing.constants.ValidationMessage.RATING_RANGE_MESSAGE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateProductReviewRequestDTO {

    private Long productId;

    @Min(value = 1, message = RATING_RANGE_MESSAGE)
    @Max(value = 5, message = RATING_RANGE_MESSAGE)
    private Integer rating;

    private boolean recommendToFriend;

    private boolean chooseSimilarAgain;

    private long userId;

}
