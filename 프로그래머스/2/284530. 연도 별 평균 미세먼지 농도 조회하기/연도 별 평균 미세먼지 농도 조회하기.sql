-- 코드를 작성해주세요
with
    temp as (select * from air_pollution where location2 like "수원")
    
select year(YM) as year, round(avg(pm_val1),2) as PM10, round(avg(pm_val2),2) as "PM2.5" from temp
group by year
order by year