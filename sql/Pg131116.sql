-- 식품분류별 가장 비싼 식품의 정보 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131116
select
    category,
    price as 'max_price',
        product_name
from
    food_product
where
        category in ('과자', '국', '김치', '식용유')
  and price in
      (
          select max(price)
          from food_product
          group by category
      )
order by
    2 desc
;