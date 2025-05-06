-- 코드를 입력하세요
with 
    a as (SELECT *, count(*) as total from online_sale 
    group by user_id, product_id)
    
select user_id, product_id from a where total > 1
order by user_id, product_id desc