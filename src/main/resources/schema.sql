-- Создание таблицы товар
create TABLE IF NOT EXISTS Product
(
    id              SERIAL PRIMARY KEY,
    description     TEXT            NOT NULL,
    price           NUMERIC(10,2)   NOT NULL,
    product_count   float         NOT NULL
);

COMMENT ON TABLE Product IS 'Таблица продуктов';

COMMENT ON COLUMN Product.id IS 'Идентификатор продукта';
COMMENT ON COLUMN Product.description IS 'Описание продукта';
COMMENT ON COLUMN Product.price IS 'Цена продукта';
COMMENT ON COLUMN Product.product_count IS 'Количество продукта';

-- Заполнение таблицы продуктов
INSERT INTO product (description, price, product_count)
VALUES ('Хлеб', 20, 1),
       ('Масло', 30, 1),
       ('Молоко', 50, 1.5),
       ('Колбаса', 50, 0.5),
       ('Кола', 100, 0.5),
       ('Пиво по акции', 100, 5),
       ('Пельмени', 100, 1),
       ('Креветки', 999, 0.3),
       ('Чай', 150, 1),
       ('Лапша', 30, 1);



-- Создание таблицы покупателей
create TABLE IF NOT EXISTS Customer
(
    id      SERIAL PRIMARY KEY ,
    name    TEXT
);
COMMENT ON TABLE Customer IS 'Таблица покупателей';

COMMENT ON COLUMN Customer.id IS 'Идентификатор покупателя';
COMMENT ON COLUMN Customer.name IS 'Имя/Фамилия покупателя';

-- Наполнение таблицы покупателей
INSERT INTO Customer (name)
VALUES ('Иван'),
       ('Петр'),
       ('Николай'),
       ('Валерий'),
       ('Константин'),
       ('Ирина'),
       ('Алена'),
       ('Анастасия'),
       ('Ольга'),
       ('Кира'),
       ('Александра');



-- Создание таблицы заказ
create TABLE IF NOT EXISTS "Order"
(
    id              SERIAL PRIMARY KEY ,
    product_id      SERIAL REFERENCES Product(id) NOT NULL ,
    customer_id     SERIAL REFERENCES Customer(id) NOT NULL ,
    order_date      DATE DEFAULT (CURRENT_DATE),
    product_count   INT DEFAULT (1)
);
COMMENT ON TABLE "Order" IS 'Таблица покупок';

COMMENT ON COLUMN "Order".product_id IS 'Идентификатор товара';
COMMENT ON COLUMN "Order".customer_id IS 'Идентификатор покупателя';
COMMENT ON COLUMN "Order".order_date IS 'Дата покупки';
COMMENT ON COLUMN "Order".product_count IS 'Количество порций продукта';

--Наполнение таблицы заказов
INSERT INTO "Order" (product_id, customer_id, product_count)
VALUES (1,1,1),
       (2,1,1),
       (3,2,1),
       (4,3,1),
       (5,4,1),
       (6,5,1),
       (7,5,1),
       (7,6,1),
       (8,7,1),
       (8,8,1),
       (1,9,1);