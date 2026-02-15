# Write your MySQL query statement below

SELECT p.product_name , SUM(o.unit) as unit
FROM Products p
LEFT JOIN 
Orders o
ON p.product_id = o.product_id
WHERE YEAR(o.order_date)='2020' AND MONTH(o.order_date)='02' 
GROUP BY p.product_id
HAVING unit>=100;


