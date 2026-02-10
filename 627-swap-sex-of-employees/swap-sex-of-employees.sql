# Write your MySQL query statement below


-- UPDATE Salary SET sex='A' where sex='F';
-- UPDATE Salary SET sex='F' where sex='M';
-- UPDATE Salary SET sex='M' where sex='A';
-- SELECT id, name,sex,salary from salary;




UPDATE Salary
SET sex= CASE
    WHEN sex='m' then 'f'
    WHEN sex='f' then 'm'
END;

-- SELECT id, name, sex, salary from Salary;

