# Write your MySQL query statement below
select 
    s.machine_id, 
    round(avg(e.timestamp-s.timestamp), 3) processing_time
from activity s
join activity e
    on (s.process_id = e.process_id
    and s.activity_type like "start"
    and e.activity_type like "end"
    and e.machine_id = s.machine_id)
group by machine_id
;