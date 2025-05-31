package ru.voroncov.cloudcomputing.dto.response.product.review;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductReviewResponseDTO {

    private long id;

    private long productId;

    private String description;

    private int rating;

    private boolean recommendToFriend;

    private boolean chooseSimilarAgain;

    private long userId;

}
