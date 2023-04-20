# Write your MySQL query statement below
SELECT id, 'Root' AS type 
FROM Tree 
WHERE p_id IS NULL

UNION

SELECT id, 'Inner' AS type 
FROM Tree 
WHERE p_id IS NOT NULL AND id IN (
    SELECT DISTINCT p_id AS id 
    FROM Tree 
    WHERE p_id IS NOT NULL
)

UNION

SELECT id, 'Leaf' AS type 
FROM Tree 
WHERE p_id IS NOT NULL AND id NOT IN (
    SELECT DISTINCT p_id AS id 
    FROM Tree 
    WHERE p_id IS NOT NULL
);
