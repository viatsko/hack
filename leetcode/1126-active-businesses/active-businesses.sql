# Write your MySQL query statement below
SELECT business_id FROM Events LEFT JOIN (
    SELECT
        event_type,
        AVG(occurences) AS average
    FROM Events
    GROUP BY event_type
) Events2
ON
    Events.event_type = Events2.event_type
WHERE
    Events.occurences > Events2.average
GROUP BY Events.business_id
HAVING COUNT(Events.business_id) >= 2
