-- https://school.programmers.co.kr/learn/courses/30/lessons/59045
-- 보호소에서 중성화한 동물
select
    o.animal_id,
    o.animal_type,
    o.name
from
    animal_outs o join animal_ins i on o.animal_id = i.animal_id
where
    o.SEX_UPON_OUTCOME regexp '^Spayed|^Neutered'
    and i.SEX_UPON_INTAKE like "Intact%"
order by
    1
;