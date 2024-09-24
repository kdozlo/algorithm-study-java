-- 조건에 맞는 사용자와 총 거래금액 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/164668

select
    u.user_id,
    u.nickname,
    sum(b.price) as 'total_sales'
from
    used_goods_user u join used_goods_board b on u.user_id = b.writer_id
where
    b.status = 'DONE'
group by
    u.user_id
having
        total_sales >= 700000
order by
    total_sales
;