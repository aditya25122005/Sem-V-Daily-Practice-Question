# Write your MySQL query statement below
SELECT name FROM salesPerson where name NOT IN(
SELECT sales.name FROM SalesPerson sales
JOIN orders o
ON o.sales_id = sales.sales_id
JOIN Company c
ON c.com_id = o.com_id
WHERE c.name = 'RED'
)