# Write your MySQL query statement below

# SELECT c.name AS 'Customers'
# FROM Customers c
# WHERE c.id NOT IN (
#     SELECT customerId FROM Orders
# );

# Tips:
# `IN` should be optimized using `INNER JOIN`/`EXISTS`.
# `NOT IN` should be optimized using `LEFT JOIN`/`NOT EXISTS`.

# Optimize 1
# SELECT c.name AS 'Customers'
# FROM Customers c
# LEFT JOIN Orders o on c.id = o.customerId
# WHERE o.customerId IS NULL;

# Optimize 2
SELECT c.name AS 'Customers'
FROM Customers c
WHERE NOT EXISTS (
    SELECT 1 FROM Orders o WHERE c.id = o.customerId
);
