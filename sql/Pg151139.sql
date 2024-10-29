-- https://school.programmers.co.kr/learn/courses/30/lessons/151139
-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
select
    month(start_date) as month,
    car_id,
    count(*) as records
from
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date between '2022-08-01' and '2022-10-31'
    group by car_id
    having count(car_id) > 4
    )
  and
    start_date between '2022-08-01' and '2022-10-31'
group by
    month,
    car_id
having
    records >0
order by
    month,
    car_id desc
;