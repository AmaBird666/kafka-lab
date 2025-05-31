insert into users(birthday, gender, discount_card_number, education, city)
    values ('2002-01-01', 'MALE', '12345', 'Высшее', 'Москва');
insert into users(birthday, gender, discount_card_number, education, city)
    values ('1999-01-01', 'FEMALE', '23456', 'Высшее', 'Сочи');
insert into users(birthday, gender, discount_card_number, education, city)
    values ('2006-01-01', 'MALE', '34567', 'Среднее', 'Саратов');
insert into users(birthday, gender, discount_card_number, education, city)
    values ('2008-01-01', 'FEMALE', '45678', 'Среднее', 'Санкт-Петербург');


insert into products(unit_price, description, country_producer, company_producer, address)
    values (100, 'Молоко', 'Россия', 'Пестравка', 'Самара');

insert into products(unit_price, description, country_producer, company_producer, address)
    values (200, 'Сыр', 'Россия', 'Пестравка', 'Самара');

insert into products(unit_price, description, country_producer, company_producer, address)
    values (50, 'Хлеб', 'Россия', 'Хлеб Компани', 'Рязань');

insert into products(unit_price, description, country_producer, company_producer, address)
    values (80, 'Сникерс', 'США', 'Mars Inc', 'Чикаго');

insert into products(unit_price, description, country_producer, company_producer, address)
    values (60, 'Твикс', 'США', 'Mars Inc', 'Чикаго');

-- User #1
insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (1, 5, true, true, 1);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (2, 3, false, true, 1);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (3, 4, true, true, 1);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (4, 2, false, false, 1);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (5, 4, true, false, 1);

-- User #2
insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (1, 3, false, true, 2);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (2, 4, true, true, 2);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (3, 1, false, false, 2);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (4, 5, true, true, 2);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (5, 2, false, true, 2);

-- User #3
insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (1, 4, true, true, 3);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (2, 5, true, true, 3);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (3, 4, true, false, 3);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (4, 4, true, false, 3);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (5, 5, true, true, 3);

-- User #4
insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (1, 5, true, true, 4);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (2, 3, false, false, 4);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (3, 4, true, true, 4);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (4, 3, false, true, 4);

insert into product_reviews(product_id, rating, recommend_to_friend, choose_similar_again, user_id)
    values (5, 5, true, true, 4);