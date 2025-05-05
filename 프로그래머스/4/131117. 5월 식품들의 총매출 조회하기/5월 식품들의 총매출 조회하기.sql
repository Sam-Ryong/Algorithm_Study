-- 코드를 입력하세요
SELECT food_product.product_id, product_name, sum(amount * price) as total_sales from 
(food_product join food_order
on food_product.product_id = food_order.product_id)
where produce_date between "2022-05-01" and "2022-05-31"
group by food_product.product_id
order by total_sales desc,food_product.product_id