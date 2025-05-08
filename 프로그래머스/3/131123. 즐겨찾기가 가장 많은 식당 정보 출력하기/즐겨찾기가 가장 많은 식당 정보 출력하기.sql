-- 코드를 입력하세요
with
    temp1 as 
    (SELECT food_type, max(favorites) as favorites from rest_info group by food_type)

select rest_info.food_type, rest_id, rest_name, rest_info.favorites 
from rest_info join temp1
on rest_info.food_type = temp1.food_type
and rest_info.favorites = temp1.favorites
order by rest_info.food_type desc