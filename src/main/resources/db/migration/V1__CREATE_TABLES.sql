CREATE TABLE customers (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    pass VARCHAR(500) NOT NULL,
    address VARCHAR(1000)
);

CREATE TABLE orders (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    customer_id BIGINT NOT NULL REFERENCES customers (id),
    order_date TIMESTAMP NOT NULL
);

CREATE TABLE goods (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    price DECIMAL NOT NULL
);

CREATE TABLE order_goods (
    order_id BIGINT NOT NULL REFERENCES orders (id),
    goods_id BIGINT NOT NULL REFERENCES goods (id),
    PRIMARY KEY (order_id, goods_id)
);