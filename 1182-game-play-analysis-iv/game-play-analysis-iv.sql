-- # Write your MySQL query statement below
-- select 
-- round(count(distinct player_id) / (select count(distinct player_id) from Activity), 2) As fraction
-- from Activity
-- where 
-- (player_id, date_sub(event_date, INTERVAL 1 DAY))
-- IN (
--     SELECT player_id, MIN(event_date) from activity group by player_id
-- )
SELECT ROUND(COUNT(A2.player_id) / COUNT(A1.player_id), 2) AS fraction
FROM
    (SELECT player_id, MIN(event_date) AS min_event_date
    FROM Activity
    GROUP BY player_id
    ) A1
LEFT JOIN Activity A2 ON A1.player_id = A2.player_id AND DATEDIFF(A2.event_date, A1.min_event_date) = 1
