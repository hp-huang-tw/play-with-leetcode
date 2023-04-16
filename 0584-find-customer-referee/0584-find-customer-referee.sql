# Write your MySQL query statement below

SELECT name 
FROM Customer 
WHERE referee_id IS NULL 

UNION ALL

SELECT name 
FROM Customer 
WHERE referee_id <> 2
;
