# Write your MySQL query statement below
-- DELETE  FROM Person
-- where id NOT IN(
--     SELECT id FROM(
--         SELECT MIN(id) as id
--         FROM person
--         GROUP BY email
--     )as temp
-- )
-- ;

DELETE p1 
FROM Person as p1
JOIN
Person as p2
ON p1.email = p2.email AND p1.id> p2.id;