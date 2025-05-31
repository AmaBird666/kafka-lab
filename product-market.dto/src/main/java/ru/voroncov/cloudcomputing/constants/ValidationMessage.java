package ru.voroncov.cloudcomputing.constants;

public class ValidationMessage {

    // Product
    public static final String EAN_PATTERN_MESSAGE = "Ean продукта должен содержать только цифры";
    public static final String UNIT_PRICE_POSITIVE_MESSAGE = "Цена продукта должна содержать положительное число";
    public static final String COUNTRY_PRODUCER_NOT_BLANK_MESSAGE = "Страна производителя продукта не может быть пустой";
    public static final String COMPANY_PRODUCER_NOT_BLANK_MESSAGE = "Компания производителя продукта не может быть пустой";


    // User
    public static final String BIRTHDAY_NOT_NULL_MESSAGE = "День рождения не может быть пустым";
    public static final String BIRTHDAY_PAST_MESSAGE = "День рождения должен быть раньше сегодняшней даты";
    public static final String BIRTHDAY_FORMAT_MESSAGE = "День рождения должен быть указан в формате dd.MM.yyyy";
    public static final String GENDER_PATTERN_MESSAGE = "Пол может быть только: male или female";
    public static final String DISCOUNT_CARD_NUMBER_PATTERN_MESSAGE = "Количество цифр дисконтной карты должно ровняться 5";


    // ProductReview
    public static final String RATING_RANGE_MESSAGE = "Укажите рейтинг цифрой от 1 до 5";
    public static final String USER_ID_NOT_BLANK_MESSAGE = "Укажите id пользователя";
}
