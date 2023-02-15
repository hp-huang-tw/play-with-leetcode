# Write your MySQL query statement below
SELECT class 
FROM (
    SELECT class, COUNT(student) AS cnt 
    FROM Courses 
    GROUP BY class
) AS tb
WHERE cnt >= 5;