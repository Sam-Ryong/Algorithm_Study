-- 코드를 작성해주세요
with
 temp as (select * from hr_employees join hr_department using (dept_id))
 
select dept_id, dept_name_en, round(avg(sal)) as avg_sal from temp
group by dept_id
order by avg_sal desc