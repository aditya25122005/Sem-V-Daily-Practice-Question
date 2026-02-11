# Write your MySQL query statement below

SELECT score, dense_rank() over(Order by score desc) as "rank" FROM Scores;;