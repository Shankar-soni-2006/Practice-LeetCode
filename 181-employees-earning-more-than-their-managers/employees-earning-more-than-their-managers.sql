# Write your MySQL query statement below
SELECT e.name AS Employee 
FROM Employee e 
JOIN Employee x ON e.managerID = x.id
WHERE e.salary > x.salary;