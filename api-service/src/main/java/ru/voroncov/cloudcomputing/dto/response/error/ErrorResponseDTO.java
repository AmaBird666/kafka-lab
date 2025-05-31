package ru.voroncov.cloudcomputing.dto.response.error;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ErrorResponseDTO {

    private int status;
    private String error;
    private String message;

}
