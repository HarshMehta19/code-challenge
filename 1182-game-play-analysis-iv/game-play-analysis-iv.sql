# Write your MySQL query statement below
select 
round(count(distinct player_id) / (select count(distinct player_id) from Activity), 2) As fraction
from Activity
where 
(player_id, date_sub(event_date, INTERVAL 1 DAY))
IN (
    SELECT player_id, MIN(event_date) from activity group by player_id
)