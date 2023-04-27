# Write your MySQL query statement below
# SELECT w1.id 
# FROM Weather w1, Weather w2
# WHERE w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY) AND w2.temperature < w1.temperature;


SELECT w1.id AS' id'
FROM Weather w1
JOIN Weather w2 ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
AND w1.temperature > w2.temperature;

