-- 코드를 입력하세요
SELECT offline_sale.product_id, sum(sales_amount) * price from 
    product join offline_sale on product.product_id = offline_sale.product_id group by offline_sale.product_id 