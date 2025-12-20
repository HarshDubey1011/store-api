create table carts
(
    id           binary(16) default (uuid_to_bin(uuid())) not null
        primary key,
    date_created date       default (curdate())           not null
);

create table cart_items
(
    id         BIGINT AUTO_INCREMENT not null
        primary key,
    cart_id    binary(16)             not null,
    product_id BIGINT                 not null,
    quantity   int default 1          not null,
    constraint cart_items_cart_product_unique
        unique (cart_id, product_id),
    constraint cart_items_cart_fk
        foreign key (cart_id) references carts (id)
            on delete cascade,
    constraint cart_items_product_fk
        foreign key (product_id) references products (id)
            on delete cascade
);