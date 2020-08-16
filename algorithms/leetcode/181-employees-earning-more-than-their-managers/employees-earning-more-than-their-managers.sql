SELECT Report.Name AS Employee FROM Employee as Report, Employee AS Manager WHERE Report.ManagerId = Manager.Id AND Report.Salary > Manager.Salary
