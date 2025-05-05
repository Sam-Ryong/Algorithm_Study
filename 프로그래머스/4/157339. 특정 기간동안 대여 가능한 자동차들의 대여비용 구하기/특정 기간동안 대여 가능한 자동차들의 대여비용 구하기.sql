select * from (select car_id, A.car_type, floor(daily_fee * (100 - discount_rate) / 100) * 30 as fee from
((select CAR_RENTAL_COMPANY_CAR.car_id, car_type, daily_fee from CAR_RENTAL_COMPANY_CAR left join
(select CAR_RENTAL_COMPANY_CAR.car_id from CAR_RENTAL_COMPANY_CAR left outer join CAR_RENTAL_COMPANY_RENTAL_HISTORY
on CAR_RENTAL_COMPANY_CAR.car_id = CAR_RENTAL_COMPANY_RENTAL_HISTORY.car_id
where 
 ((start_date between "2022-11-01" and "2022-11-30") or (end_date between "2022-11-01" and "2022-11-30"))
 or
 (start_date <"2022-11-01" and end_date >= "2022-11-30")
group by CAR_RENTAL_COMPANY_CAR.car_id) as A
on CAR_RENTAL_COMPANY_CAR.car_id = A.car_id
where A.car_id is null) as A
join
CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
on A.car_type = CAR_RENTAL_COMPANY_DISCOUNT_PLAN.car_type)
where CAR_RENTAL_COMPANY_DISCOUNT_PLAN.duration_type = "30일 이상") as A
where fee between 500000 and 2000000
order by fee desc, car_type, car_id desc