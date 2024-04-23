# Write your MySQL query statement below
-- select activity_date as day, count(distinct user_id) as active_users from Activity where extract(YEAR_MONTH from activity_date) = '201907' group by activity_date
-- select activity_date as day, count(distinct user_id) as active_users from Activity 
-- where activity_date between '2019-06-28' and '2019-08-24' group by activity_date
select activity_date as day, count(distinct user_id) as active_users from Activity 
WHERE DATEDIFF('2019-07-27', activity_date) < 30 AND activity_date <= '2019-07-27' group by activity_date;