package ru.voroncov.cloudcomputing.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }


}
