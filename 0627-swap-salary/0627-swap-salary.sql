# Write your MySQL query statement below
#UPDATE Salary SET sex = IF (sex = 'm', 'f', 'm');

UPDATE salary
SET sex =
    CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END;