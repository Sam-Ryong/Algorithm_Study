-- 코드를 입력하세요
SELECT user_id, nickname, concat(city,' ', street_address1,concat(' ', street_address2)) as 전체주소, 
concat(concat(concat(concat(substring(TLNO,1,3),'-'),substring(TLNO,4,4)),'-'), substring(TLNO,8,4)) as 전화번호 from used_goods_board as a 
join used_goods_user as b on a.writer_id = b.user_id
group by user_id
having count(*) >= 3
order by user_id desc