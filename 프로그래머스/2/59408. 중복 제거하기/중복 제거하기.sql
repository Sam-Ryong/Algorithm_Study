-- 코드를 입력하세요
select count(*) as count from (SELECT * from animal_ins where name is not null group by name) as T