# Write your MySQL query statement below

# SELECT employee_id, salary * (name NOT LIKE 'M%') * (employee_id  % 2) AS bonus 
# FROM Employees
# ORDER BY employee_id;

# SELECT employee_id, IF (name NOT LIKE 'M%' AND employee_id % 2 <> 0, salary, 0) AS bonus 
# FROM Employees
# ORDER BY employee_id;

-- select entries with odd  employee id and name not start with M
    SELECT employee_id , salary AS bonus 
    FROM employees 
    WHERE employee_id % 2 <> 0 AND name NOT LIKE 'M%'

-- join both selection 
    union

-- select remaining entries from table 
    SELECT employee_id , 0 AS bonus
    FROM employees
    WHERE employee_id % 2 = 0 OR name LIKE 'M%'
    ORDER BY employee_id;
