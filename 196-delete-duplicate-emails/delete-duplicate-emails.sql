# Write your MySQL query statement below
DELETE  FROM Person
where id NOT IN(
    SELECT id FROM(
        SELECT MIN(id) as id
        FROM person
        GROUP BY email
    )as temp
)
;