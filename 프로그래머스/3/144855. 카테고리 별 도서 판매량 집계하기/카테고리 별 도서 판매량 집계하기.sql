-- 코드를 입력하세요
SELECT category, sum(sales) 
from book join book_sales 
on book.book_id = book_sales.book_id
where sales_date between "2022-01-01" and "2022-01-31"
group by category
order by category