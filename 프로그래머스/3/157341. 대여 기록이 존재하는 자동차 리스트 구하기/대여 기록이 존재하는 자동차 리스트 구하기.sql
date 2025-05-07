-- 코드를 입력하세요
SELECT distinct CAR_RENTAL_COMPANY_CAR.car_id
from CAR_RENTAL_COMPANY_CAR join CAR_RENTAL_COMPANY_RENTAL_HISTORY 
on CAR_RENTAL_COMPANY_CAR.car_id = CAR_RENTAL_COMPANY_RENTAL_HISTORY.car_id
where car_type like "세단"
and month(start_date) = 10
order by car_id desc