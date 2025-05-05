-- 코드를 입력하세요
with 
    user_2021 
        as (SELECT * from user_info where year(joined) = 2021),
    total
        as (select count(*) as total from user_2021),
    sales 
        as (select user_2021.user_id, sales_date, month(sales_date) as month from user_2021 join online_sale on user_2021.user_id = online_sale.user_id),
    filtered_sales
        as (select user_id, sales_date from sales group by month, user_id)

select 
    year(sales_date) as year,
    month(sales_date) as month,
    count(*) as PURCHASED_USERS,
    round(count(*)/total, 1)as PUCHASED_RATIO
from filtered_sales join total
group by year, month
order by year, month
