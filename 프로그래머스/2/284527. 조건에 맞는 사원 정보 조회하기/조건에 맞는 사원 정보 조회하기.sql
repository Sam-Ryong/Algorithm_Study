-- 코드를 작성해주세요
with
    temp as (select * from hr_grade where year = 2022),
    temp2 as (select sum(score) as score, emp_no from temp
                group by emp_no
                order by score desc
                limit 1)
select score, emp_no, emp_name, position, email from temp2
natural join hr_employees


