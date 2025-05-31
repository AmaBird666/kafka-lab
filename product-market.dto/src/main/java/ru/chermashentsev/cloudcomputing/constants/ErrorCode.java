package ru.voroncov.cloudcomputing.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    VALID_ERROR("Ошибка валидации"),
    DIFFERENT_EAN("Ean в строке запроса не соответствует ean в теле запроса"),
    USER_NOT_FOUND("Пользователь с id %s не найден"),
    PRODUCT_NOT_FOUND("Продукт с ean %s не найден"),
    UNSUPPORTED_MEDIA_TYPE("Тип контента не поддерживается")
    ;


    private final String message;


    public String format(Object...args) {
        return String.format(message, args);
    }

}
