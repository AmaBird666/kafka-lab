package ru.voroncov.cloudcomputing.dto.request.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

import static ru.voroncov.cloudcomputing.constants.ValidationMessage.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateUserRequestDTO {

    @NotNull(message = BIRTHDAY_NOT_NULL_MESSAGE)
    @Past(message = BIRTHDAY_PAST_MESSAGE)
    private LocalDate birthday;

    @Pattern(regexp = "male|female", message = GENDER_PATTERN_MESSAGE)
    private String gender;

    @Pattern(regexp = "^[0-9]{5}$", message = DISCOUNT_CARD_NUMBER_PATTERN_MESSAGE)
    private String discountCardNumber;

    private boolean isHaveChildren;

    private boolean isMarried;

    private String education;

    private String city;

}
