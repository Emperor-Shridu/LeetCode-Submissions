-- # Write your MySQL query statement below
-- select
--     customer_id,
--     count(visit_id) count_no_trans
-- from visits
-- where visit_id not in(
--     select visit_id
--     from transactions
-- )
-- group by customer_id;

select 
    v.customer_id,
    count(v.visit_id) count_no_trans
from visits v
where not exists(
    select 1
    from transactions t
    where  v.visit_id = t.visit_id
)
group by customer_id;