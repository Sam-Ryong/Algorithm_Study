-- 코드를 입력하세요
with 
    temp as (SELECT host_id, count(*) as c from places group by host_id),
    temp1 as (select * from temp where c >= 2)
    
select id, name ,host_id from places join temp1 using (host_id)