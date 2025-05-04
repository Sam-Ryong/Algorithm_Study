-- 코드를 입력하세요
SELECT first_half.flavor from First_Half join icecream_info on first_half.flavor = icecream_info.flavor
where icecream_info.ingredient_type = "fruit_based" and total_order > 3000
ORDER BY TOTAL_ORDER desc