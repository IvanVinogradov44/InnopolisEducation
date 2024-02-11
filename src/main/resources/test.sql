-- 1 Получить список возможных продуктов
SELECT
    description,
    price,
    product_count
FROM product;

-- 2 Вывести список покупок для выбранного пользователя
SELECT c.name, p.description, o.order_date
FROM Customer c
JOIN "Order" o on c.id = o.customer_id
JOIN product p on o.product_id = p.id;

-- 3 Изменить цену продукта
UPDATE  Product
SET     price = 150
where   description = 'Кола';

-- 4 Удалить устаревшие покупки
DELETE
FROM "Order"
WHERE (CURRENT_DATE - order_date)>30;

-- 5 Удаление пользователей без покупок
DELETE
FROM    customer
WHERE id IN (Select c.id
       from customer c
       FULL OUTER JOIN "Order" o on c.id = o.customer_id
       where o.id is null);

-- 6 Получить список товаров купленных более чем одним покупателем
SELECT p.description
from product p
join "Order" o on p.id = o.product_id
GROUP BY p.id
HAVING count(o.customer_id)>1;

-- 7 К продуктам которые не покупали больше месяца добавить пометку (Просрочка)
UPDATE product p
SET description = p.description || ' (Просрочка)'
where id IN (SELECT DISTINCT product_id
            from "Order"
            GROUP BY product_id
            HAVING (CURRENT_DATE - max(order_date))>30)
OR  ID IN (SELECT p.id
                from product p
                FULL OUTER JOIN "Order" o ON p.id = o.product_id
                where o.product_id is null);
