CREATE DATABASE zebra;
USE zebra;

CREATE TABLE product
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(200),
    price    DOUBLE,
    amount   INT      DEFAULT 0,
    add_time DATETIME DEFAULT now()
);

INSERT INTO product (name, price)
VALUES ('Test Product', 1);