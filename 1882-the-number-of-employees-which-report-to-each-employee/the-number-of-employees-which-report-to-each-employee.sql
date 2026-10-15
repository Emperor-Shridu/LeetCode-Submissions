# Write your MySQL query statement below
select
    m.employee_id employee_id, 
    m.name name,
    count(*) reports_count,
    round(avg(e.age),0) average_age
from
    employees m
join
    employees e
on m.employee_id = e.reports_to
group by m.employee_id
order by m.employee_id;