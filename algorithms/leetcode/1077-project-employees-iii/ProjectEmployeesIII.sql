# Write your MySQL query statement below
SELECT project_id, Employee.employee_id
FROM Project
LEFT JOIN Employee ON Employee.employee_id = Project.employee_id
WHERE (project_id, experience_years) IN
(
    SELECT project_id, MAX(experience_years) as experience_years
    FROM Project
    LEFT JOIN Employee ON Employee.employee_id = Project.employee_id
    GROUP BY project_id
)
