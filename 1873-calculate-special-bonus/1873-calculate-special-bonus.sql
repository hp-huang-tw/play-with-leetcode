# Write your MySQL query statement below
SELECT employee_id, salary * (name NOT LIKE 'M%') * (employee_id  % 2) AS bonus 
FROM Employees
ORDER BY employee_id;