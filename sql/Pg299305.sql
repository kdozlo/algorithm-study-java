-- 대장균들의 자식의 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/299305

select
    p.id,
    coalesce(count, 0) as 'child_count'
from
    ECOLI_DATA p
        left join (
            select
                parent_id as 'id',
                    count(*) as 'count'
            from
                ecoli_data
            group by
                parent_id
            having
                parent_id is not null
        ) c
        on
            p.id = c.id
order by
    p.id
;
