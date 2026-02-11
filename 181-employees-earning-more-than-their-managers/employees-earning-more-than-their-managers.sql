# Write your MySQL query statement below

select name as Employee from Employee e1
where e1.salary > (SELECT salary from Employee WHERE id=e1.managerId);