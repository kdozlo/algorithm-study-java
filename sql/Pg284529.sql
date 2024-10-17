-- 부서별 평균 연봉 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/284529
select
    d.dept_id,
    d.dept_name_en,
    round(avg(e.sal)) as 'avg_sal'
from
    hr_department d join hr_employees e on d.dept_id = e.dept_id
group by
    d.dept_id
order by
    avg_sal desc
;