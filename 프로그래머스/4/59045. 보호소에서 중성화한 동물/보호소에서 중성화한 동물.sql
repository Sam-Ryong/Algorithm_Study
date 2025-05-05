-- 코드를 입력하세요
SELECT i.animal_id, i.animal_type, i.name from ANIMAL_INS as i join ANIMAL_OUTS as o on i.animal_id = o.animal_id
where 
(i.sex_upon_intake = "Intact Male" or i.sex_upon_intake = "Intact Female") 
and
(o.sex_upon_outcome = "Spayed Female" or o.sex_upon_outcome ="Neutered Male")
order by animal_id