# Write your MySQL query statement below
SELECT person.firstName, person.lastName, address.city, address.state
FROM Person 
LEFT JOIN ADDRESS   ON Person.personId = Address.personId;

-- p and a are table names