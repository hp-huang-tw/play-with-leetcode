# Write your MySQL query statement below
SELECT name 
FROM SalesPerson s 
WHERE s.sales_id NOT IN
    ( 
        SELECT o.sales_id FROM Orders o
        LEFT JOIN Company c ON c.com_id = o.com_id
        WHERE c.name = 'RED'
    )
    
    # |--------------------------------------------------|------------------------|
    # | Order                                            | Company                |
    # |--------------------------------------------------|------------------------|
    # | order_id | date     | com_id | sales_id | amount | com_id | name | city   |
    # |----------|----------|--------|----------|--------|--------|------|--------|
    # | 3        | 3/1/2014 | 1      | 1        | 50000  | 1      | RED  | Boston |
    # | 4        | 4/1/2014 | 1      | 4        | 25000  | 1      | RED  | Boston |
    # |----------|----------|--------|----------|--------|--------|------|--------|