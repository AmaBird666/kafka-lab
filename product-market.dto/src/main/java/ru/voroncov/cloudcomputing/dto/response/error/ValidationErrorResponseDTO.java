package ru.voroncov.cloudcomputing.dto.response.error;

import java.util.Map;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ValidationErrorResponseDTO {

    private int status;
    private String error;
    private String message;
    private Map<String, String> validationErrors;

}
