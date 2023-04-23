# Write your MySQL query statement below
# SELECT customer_id, COUNT(customer_id) AS count_no_trans
# FROM Visits v
# LEFT JOIN Transactions t ON v.visit_id = t.visit_id
# WHERE t.transaction_id IS NULL
# GROUP BY customer_id;


SELECT customer_id, COUNT(customer_id) AS count_no_trans
FROM Visits v
WHERE NOT EXISTS (
    SELECT DISTINCT visit_id 
    FROM Transactions t
    WHERE v.visit_id = t.visit_id
)
GROUP BY customer_id;