-- 특정 물고기를 잡은 총 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/298518
SELECT
    COUNT(fi.fish_type) AS "fish_count"
FROM
    fish_name_info fin
        JOIN fish_info fi ON fi.fish_type = fin.fish_type
WHERE
        fin.fish_name IN ('BASS', 'SNAPPER');