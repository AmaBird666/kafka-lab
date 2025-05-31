package ru.voroncov.cloudcomputing.dto.response.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductResponseDTO {

    private long id;

    private BigDecimal unitPrice;

    private String description;

    private String countryProducer;

    private String companyProducer;

    private String address;

}
