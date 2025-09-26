-- 코드를 입력하세요
with
    temp as (select * from animal_outs where time(datetime) between '09:00' and '19:59')
    
select hour(datetime) as hour, count(*) from temp
group by hour(datetime)
order by hour