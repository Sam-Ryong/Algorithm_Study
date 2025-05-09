-- 코드를 작성해주세요
with
    temp as (select a.id,a.parent_id,a.genotype,b.genotype as parent_genotype from ecoli_data as a join ecoli_data as b on a.parent_id = b.id)
    
select id,genotype,parent_genotype from temp
where  genotype & parent_genotype = parent_genotype
order by id