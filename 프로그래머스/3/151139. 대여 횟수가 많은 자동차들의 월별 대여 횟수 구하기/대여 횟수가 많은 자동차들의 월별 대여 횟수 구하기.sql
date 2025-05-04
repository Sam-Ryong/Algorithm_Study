-- 코드를 입력하세요
select month, A.car_id, A.records from (select month(start_date) as month, car_id, count(*) as records from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between '2022-08-01' and '2022-11-01'
group by month, car_id) as A
join
(select car_id, count(*) as records from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between '2022-08-01' and '2022-11-01'
group by car_id having records >= 5) as B
on A.car_id = B.car_id
order by month, car_id desc