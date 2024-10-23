-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/157340
SELECT
    CAR_ID,
    MAX (CASE
             WHEN '2022-10-16' BETWEEN START_DATE AND END_DATE THEN '대여중'
             ELSE '대여 가능'
        END) AS AVAILABILITY
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by
    car_id
ORDER BY
    CAR_ID DESC
;
