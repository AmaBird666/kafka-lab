package ru.voroncov.cloudcomputing.dto.response.error;

import lombok.*;

import java.util.Map;

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
