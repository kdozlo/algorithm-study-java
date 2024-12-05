-- 업그레이드 할 수 없는 아이템 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/273712

-- not in 사용
select
    i.item_id,
    i.item_name,
    i.rarity
from
    item_info i
where
        i.item_id not in (
        select distinct parent_item_id
        from item_tree
        where parent_item_id is not null
    )
order by
    i.item_id desc
;

-- not exists 사용
select
    i.item_id,
    i.item_name,
    i.rarity
from
    item_info i
where
    not exists (
        select 1
        from item_tree t
        where t.parent_item_id = i.item_id
    )
order by
    i.item_id desc
;

-- left join 사용
SELECT
    i.item_id,
    i.item_name,
    i.rarity
FROM
    item_info i
        LEFT JOIN item_tree t ON i.item_id = t.parent_item_id
WHERE
    t.parent_item_id IS NULL
ORDER BY
    i.item_id DESC;
