-- 코드를 입력하세요
with
    temp as (select car_id, if ('2022-10-16' between start_date and end_date, "대여중", "대여 가능") as availability 
from car_rental_company_rental_history
order by car_id desc),
    temp2 as (select * from temp
where availability = '대여중'),
    temp3 as (select * from temp
group by car_id)

select a.car_id, if (b.availability is null, '대여 가능', '대여중') as availability from temp3 as a left outer join temp2 as b on b.car_id = a.car_id
order by car_id desc