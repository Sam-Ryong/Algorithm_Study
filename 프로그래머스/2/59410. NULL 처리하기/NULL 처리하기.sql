-- 코드를 입력하세요
with
    temp as (select animal_type, name, SEX_UPON_INTAKE from animal_ins)
    
select animal_type, if(name is null, 'No name', name) as name, SEX_UPON_INTAKE from temp
    