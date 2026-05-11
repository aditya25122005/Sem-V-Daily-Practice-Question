CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT salary
      FROM(
        SELECT DISTINCT salary, DENSE_RANK() OVER(ORDER BY SALARY DESC) as rnk
        FROM Employee
      )as t
      Where rnk=N

  );
END