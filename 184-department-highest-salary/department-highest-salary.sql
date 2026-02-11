# Write your MySQL query statement below
Select d.name as Department, e.name as Employee, e.salary as Salary
FROM Employee as e
JOIN 
department as d
ON e.departmentId = d.id

where e.salary = (SELECT MAX(salary) 
                FROM EMPLOYEE
                WHERE departmentId=e.departmentId
                );




                

