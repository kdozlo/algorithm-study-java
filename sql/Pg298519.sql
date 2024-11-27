-- 특정 조건을 만족하는 물고기별 수와 최대 길이 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/298519

select
    count(*) as 'fish_count',
        max(length) as 'max_length',
        fish_type
from
    FISH_INFO
group by
    fish_type
having
        avg(case
                when length is null then 10
                else length
            end) >= 33
order by
    fish_type
;
