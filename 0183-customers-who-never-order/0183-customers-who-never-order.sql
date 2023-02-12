# Write your MySQL query statement below
# SELECT name AS `Customers` FROM Customers 
# WHERE id NOT IN (SELECT DISTINCT customerId FROM Orders);

# SELECT name AS `Customers` FROM Customers 
# WHERE id NOT IN (SELECT customerId FROM Orders);

# OPTIMIZE
# SELECT name AS `Customers` FROM Customers c
# WHERE NOT EXISTS (SELECT 1 FROM Orders o WHERE o.customerId = c.id);

SELECT c.name AS `Customers` FROM Customers c
LEFT JOIN Orders o ON c.id = o.customerId
WHERE o.id IS NULL;
