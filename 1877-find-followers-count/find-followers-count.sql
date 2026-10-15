# Write your MySQL query statement below
select
    user_id,
    count(*) followers_count
from followers
group by user_id
order by user_id asc;