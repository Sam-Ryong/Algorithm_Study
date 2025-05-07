-- 코드를 입력하세요
with
    temp1 as (SELECT INGREDIENT_TYPE, total_order from first_half as a join icecream_info as b on a.flavor = b.flavor)

select INGREDIENT_TYPE, sum(total_order) as total_order from temp1 group by INGREDIENT_TYPE
order by total_order