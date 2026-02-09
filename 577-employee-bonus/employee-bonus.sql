# Write your MySQL query statement below
select Employee.name,Bonus.bonus  FROM Employee
LEFT JOIN BONUS
on Employee.empID = Bonus.empId
WHERE Bonus.bonus<1000 or Bonus.bonus is NULL
;