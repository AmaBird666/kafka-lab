package ru.voroncov.cloudcomputing.dto.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

import static ru.voroncov.cloudcomputing.constants.ValidationMessage.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateProductRequestDTO {

    @Positive(message = UNIT_PRICE_POSITIVE_MESSAGE)
    private BigDecimal unitPrice;

    private String description;

    @NotBlank(message = COUNTRY_PRODUCER_NOT_BLANK_MESSAGE)
    private String countryProducer;

    @NotBlank(message = COMPANY_PRODUCER_NOT_BLANK_MESSAGE)
    private String companyProducer;

    private String address;

}
