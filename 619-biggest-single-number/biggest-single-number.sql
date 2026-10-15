# Write your MySQL query statement below
select max(num) num from(select
    num,
    count(*)
from mynumbers
group by num
having count(*) = 1) s;