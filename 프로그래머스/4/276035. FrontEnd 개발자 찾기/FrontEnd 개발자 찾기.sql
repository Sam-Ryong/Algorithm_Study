-- 코드를 작성해주세요
with
    front_end_code as (select CODE from SKILLCODES where category = "Front End"),
    ciba as (select id, email, first_name, last_name from 
    DEVELOPERS join front_end_code
    on skill_code & code = code)
    
select distinct * from ciba order by id


    
