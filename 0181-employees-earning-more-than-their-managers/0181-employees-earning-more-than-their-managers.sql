# Write your MySQL query statement below
# SELECT * FROM Employee e1
# LEFT JOIN Employee e2 ON e1.managerId = e2.id;

# | e1                              | e2                              |
# +----+-------+--------+-----------+----+-------+--------+-----------+
# | id | name  | salary | managerId | id | name  | salary | managerId |
# +----+-------+--------+-----------+----+-------+--------+-----------+
# | 1  | Joe   | 70000  | 3         | 3  | Sam   | 60000  | Null      |
# | 2  | Henry | 80000  | 4         | 4  | Max   | 90000  | Null      |
# | 3  | Sam   | 60000  | Null      |Null| Null  | Null   | Null      |
# | 4  | Max   | 90000  | Null      |Null| Null  | Null   | Null      |
# +----+-------+--------+-----------+----+-------+--------+-----------+

SELECT e1.name AS Employee FROM Employee e1
LEFT JOIN Employee e2 ON e1.managerId = e2.id
WHERE e1.salary > e2.salary;