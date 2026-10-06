# Write your MySQL query statement below
select 
    t.id 
from weather t 
join weather y 
    on datediff(t.recordDate, y.recordDate) = 1
where t.temperature>y.temperature;