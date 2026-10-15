# Write your MySQL query statement below
select
    contest_id,
    round(count(user_id)/(select count(*) from users)*100.0,2) percentage
from register
group by contest_id
order by 
    percentage desc,
    contest_id asc;    