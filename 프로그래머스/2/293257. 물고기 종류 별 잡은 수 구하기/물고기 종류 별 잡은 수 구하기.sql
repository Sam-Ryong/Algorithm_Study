-- 코드를 작성해주세요
with 
    temp as (select fish_info.fish_type, fish_name from fish_info join fish_name_info on fish_info.fish_type = fish_name_info.fish_type)
    
select count(*) as fish_count,fish_name from temp
group by fish_name
order by fish_count desc
