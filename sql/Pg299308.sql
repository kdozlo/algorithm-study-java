-- 분기별 분화된 대장균의 개체 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/299308

-- 직접 계산
select
    concat(ceil(month(DIFFERENTIATION_DATE) / 3), 'Q') as 'QUARTER',
        count(id) as 'ECOLI_COUNT'
from
    ECOLI_DATA
group by
    QUARTER
order by
    QUARTER
;


-- case when then end
select
    case
        when month(DIFFERENTIATION_DATE) between 1 and 3 then '1Q'
        when month(DIFFERENTIATION_DATE) between 4 and 6 then '2Q'
        when month(DIFFERENTIATION_DATE) between 7 and 9 then '3Q'
        else '4Q'
end as 'QUARTER',
    count(id) AS 'ECOLI_COUNT'
from ECOLI_DATA
group by QUARTER
order by QUARTER
;

-- QUARTER함수 이용
select
    concat(quarter(DIFFERENTIATION_DATE), 'Q') as 'QUARTER',
    count(id) as 'ECOLI_COUNT'
from ECOLI_DATA
group by QUARTER
order by QUARTER
;
