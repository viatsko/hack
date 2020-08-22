# Write your MySQL query statement below
SELECT sale_date, SUM(if(fruit = "apples", sold_num, -sold_num)) as DIFF FROM Sales GROUP BY sale_date;
