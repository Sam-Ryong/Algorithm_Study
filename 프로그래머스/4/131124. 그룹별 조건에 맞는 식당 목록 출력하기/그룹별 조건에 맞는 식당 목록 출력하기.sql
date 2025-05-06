with 
    most as (SELECT count(*) as most from member_profile as a join rest_review as b
on a.member_id = b.member_id
group by a.member_id order by most desc
limit 1),
    b as (select member_id, count(*) as ct from rest_review join most group by member_id),
    c as (SELECT a.member_id, member_name, review_text, date_format(review_date,"%Y-%m-%d") as review_date from member_profile as a join rest_review as b
on a.member_id = b.member_id)

select member_name,review_text,review_date from (select c.member_id, member_name, review_date, review_text, ct from c join b on c.member_id = b.member_id)as e join most
on most = e.ct
order by review_date, review_text
