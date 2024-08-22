-- 연도별 대장균 크기의 편차 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/299310

-- 서브 쿼리,left join 방법
select
    year(DIFFERENTIATION_DATE) as 'year',
    e2.year_dev - e1.size_of_colony as 'year_dev',
    id
from
    ECOLI_DATA e1
left join
    (
        select
            max(size_of_colony) as 'year_dev',
            year(DIFFERENTIATION_DATE) as 'year'
        from
            ECOLI_DATA
        group by year
    ) as e2
on
    year(e1.DIFFERENTIATION_DATE) = e2.year
order by
    year,
    year_dev
;

-- over, partition by 방법
select
    year(DIFFERENTIATION_DATE) as 'year',
    (max(SIZE_OF_COLONY) OVER (PARTITION BY YEAR(DIFFERENTIATION_DATE)) - SIZE_OF_COLONY) as 'year_dev',
    ID
from
    ECOLI_DATA
order by
    year,
    year_dev
;
