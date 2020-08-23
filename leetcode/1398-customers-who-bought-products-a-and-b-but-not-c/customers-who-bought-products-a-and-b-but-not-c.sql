# Write your MySQL query statement below
SELECT Orders.customer_id, Customers.customer_name FROM Orders LEFT JOIN Customers ON Customers.customer_id = Orders.customer_id WHERE Orders.customer_id NOT IN (SELECT customer_id FROM Orders WHERE product_name = 'C') GROUP BY customer_id having SUM(case when product_name in ('A', 'B') then 1 else 0 end) = 2 ;
