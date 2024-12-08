-- 5월 식품들의 총매출 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131117

-- 방법 1
select
    p.product_id,
    p.product_name,
    sum(p.price * o.amount) as 'total_sales'
from
    food_product p join food_order o on p.product_id = o.product_id
where
    year(o.produce_date) = '2022' and month(o.produce_date) = '5'
group by
    p.product_id
order by
    3 desc, 1
;

-- 방법 2
select
    p.product_id,
    p.product_name,
    p.price * o.amount as 'total_sales'
from
    food_product p join (
        select product_id, sum(amount) as 'amount'
        from food_order
        where
            year(produce_date) = '2022' and month(produce_date) = '5'
        group by product_id) o
    on p.product_id = o.product_id
order by
    3 desc, 1
;