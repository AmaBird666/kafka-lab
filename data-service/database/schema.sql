create table products (
    id bigint generated always as identity primary key,
    unit_price decimal(10, 2) not null,
    description varchar(255),
    country_producer varchar(255),
    company_producer varchar(255),
    address varchar(255)
);

create table users (
    id bigint generated always as identity primary key,
    birthday date not null,
    gender varchar(6) not null,
    discount_card_number varchar(5),
    have_children boolean default false,
    married boolean default false,
    education varchar(255),
    city varchar(255)
);

create table product_reviews (
    id bigint generated always as identity primary key,
    product_id bigint not null,
    rating int not null,
    recommend_to_friend boolean default false,
    choose_similar_again boolean default false,
    user_id bigserial not null,

    foreign key (product_id) references products(id) on delete cascade,
    foreign key (user_id) references users(id) on delete cascade
);

create table kpi_metrics (
    product_id bigint primary key,
    avg_rating float,
    satisfaction_index float,
    attractiveness_index float,

    foreign key (product_id) references products(id) on delete cascade
);