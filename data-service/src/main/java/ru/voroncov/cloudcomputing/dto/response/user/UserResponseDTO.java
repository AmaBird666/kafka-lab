package ru.voroncov.cloudcomputing.dto.response.user;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserResponseDTO {

    private long id;

    private LocalDate birthday;

    private String gender;

    private String discountCardNumber;

    private boolean isHaveChildren;

    private boolean isMarried;

    private String education;

    private String city;

}
