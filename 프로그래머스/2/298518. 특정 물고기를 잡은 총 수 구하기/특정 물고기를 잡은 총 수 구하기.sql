-- 코드를 작성해주세요
with
    temp as (select fish_name as fish_count from FISH_INFO natural join FISH_NAME_INFO
having fish_name in ('BASS', 'SNAPPER'))

select count(*) as fish_count from temp