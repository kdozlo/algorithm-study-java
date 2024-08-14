-- 월별 잡은 물고기 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/293260

select
    count(id) as 'fish_count',
    month(time) as 'month'
from
    fish_info
group by
    month(time)
order by month
;