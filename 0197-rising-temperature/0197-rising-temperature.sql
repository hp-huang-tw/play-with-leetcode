# Write your MySQL query statement below
SELECT w1.id 
FROM Weather w1, Weather w2
WHERE w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY) AND w2.temperature < w1.temperature;