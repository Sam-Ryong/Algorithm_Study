-- 코드를 작성해주세요
with 
    a as (select id from ecoli_data where parent_id is null),
    b as (select ecoli_data.id from ecoli_data join a on ecoli_data.parent_id = a.id)



select ecoli_data.id from ecoli_data join b on ecoli_data.parent_id = b.id
order by id