-- 대여 기록이 존재하는 자동차 리스트 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/157341
select
    distinct c.car_id
from
    CAR_RENTAL_COMPANY_CAR c
        join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on c.car_id = h.car_id
where
    month(h.start_date) = 10 and c.car_type = "세단"
order by
    car_id desc
;