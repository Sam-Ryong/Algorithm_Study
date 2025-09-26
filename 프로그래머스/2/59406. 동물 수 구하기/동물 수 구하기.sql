-- 코드를 입력하세요
SELECT count(*) from (select * from animal_ins group by animal_id) as a;