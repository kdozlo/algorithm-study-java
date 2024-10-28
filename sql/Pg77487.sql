-- https://school.programmers.co.kr/learn/courses/30/lessons/77487
-- 헤비 유저가 소유한 장소
select
    id,
    name,
    host_id
from
    places
where host_id in (
    select
        host_id
    from
        places
    group by
        host_id
    having
            count(host_id) > 1
)
order by
    id
;