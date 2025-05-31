package ru.voroncov.cloudcomputing.exception.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.voroncov.cloudcomputing.constants.ValidationMessage;
import ru.voroncov.cloudcomputing.dto.response.error.ErrorResponseDTO;
import ru.voroncov.cloudcomputing.dto.response.error.ValidationErrorResponseDTO;
import ru.voroncov.cloudcomputing.exception.BadRequestException;
import ru.voroncov.cloudcomputing.exception.ProductNotFoundException;
import ru.voroncov.cloudcomputing.exception.UnsupportedMediaTypeException;
import ru.voroncov.cloudcomputing.exception.UserNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static ru.voroncov.cloudcomputing.constants.ErrorCode.UNSUPPORTED_MEDIA_TYPE;
import static ru.voroncov.cloudcomputing.constants.ErrorCode.VALID_ERROR;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return buildValidationErrorResponse(new BadRequestException(VALID_ERROR.getMessage()), HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Map<String, String> errors = new HashMap<>();

        if (ex.getCause() instanceof InvalidFormatException cause) {
            if (cause.getTargetType().equals(BigDecimal.class)) {
                errors.put("unitPrice", ValidationMessage.UNIT_PRICE_POSITIVE_MESSAGE);
            }
            else if (cause.getTargetType().equals(LocalDate.class)) {
                errors.put("birthday", ValidationMessage.BIRTHDAY_FORMAT_MESSAGE);
            }
            else if (cause.getTargetType().equals(Integer.class)) {
                errors.put("rating", ValidationMessage.RATING_RANGE_MESSAGE);
            }
        }

        return buildValidationErrorResponse(new BadRequestException(VALID_ERROR.getMessage()), HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponseDTO> handleMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        return buildErrorResponse(new UnsupportedMediaTypeException(UNSUPPORTED_MEDIA_TYPE.getMessage()), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequestExceptions(BadRequestException ex) {
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundExceptions(ProductNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundExceptions(UserNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponseDTO> buildErrorResponse(Exception ex, HttpStatus status) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage()
        );

        return ResponseEntity.status(status).body(errorResponseDTO);
    }

    private ResponseEntity<ValidationErrorResponseDTO> buildValidationErrorResponse(Exception ex, HttpStatus status,
                                                                          Map<String, String> validationErrors) {

        ValidationErrorResponseDTO errorResponseDTO = new ValidationErrorResponseDTO(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                validationErrors
        );

        return ResponseEntity.status(status).body(errorResponseDTO);
    }

}
