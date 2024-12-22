-- 서울에 위치한 식당 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131118

select
    ri.rest_id,
    ri.rest_name,
    ri.food_type,
    ri.favorites,
    ri.address,
    round(avg(review_score), 2) as score
from
    REST_INFO ri join REST_REVIEW rr
                      on ri.rest_id = rr.rest_id
group by
    ri.rest_id
having
        ri.address like '서울%'
order by
    6 desc, 4 desc
;