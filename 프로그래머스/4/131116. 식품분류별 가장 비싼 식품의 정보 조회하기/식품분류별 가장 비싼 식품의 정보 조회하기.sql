-- 코드를 입력하세요
with 
    temp1 as (SELECT category, max(price) as max_price from food_product
where category in ("과자","국","김치","식용유")
group by category)

select temp1.category, max_price, product_name from food_product join temp1
on food_product.category = temp1.category and food_product.price = temp1.max_price
order by max_price desc