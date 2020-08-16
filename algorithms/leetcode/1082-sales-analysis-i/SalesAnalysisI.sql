# Write your MySQL query statement below
SELECT seller_id FROM Sales GROUP BY seller_id HAVING SUM(price) = 
(SELECT SUM(price) AS total_price FROM Sales GROUP BY seller_id ORDER BY total_price DESC LIMIT 1);
