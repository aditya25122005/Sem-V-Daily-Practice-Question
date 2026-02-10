

SELECT (
SELECT DISTINCT salary as SecondHighestSalary 
FROM employee 
ORDER BY salary desc
LIMIT 1 OFFSET 1
) AS SecondHighestSalary;