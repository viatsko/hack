SELECT
    salesperson.name
FROM
    salesperson
WHERE
    salesperson.sales_id
    NOT IN (
        SELECT
            orders.sales_id
        FROM
            orders
        JOIN
            company
        ON
            company.com_id = orders.com_id
        AND
            company.name = 'RED'
    )
ORDER BY
    salesperson.name
