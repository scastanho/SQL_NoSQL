-- Create table Employees
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,          
    Name VARCHAR(100) NOT NULL,          
    Department VARCHAR(50) NOT NULL,     
    Salary DECIMAL(10, 2) NOT NULL       
);

-- Insert data in table Employees
INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES 
(1, 'John Smith', 'Engineering', 75000),
(2, 'Eric Hemsworth', 'Marketing', 65000),
(3, 'Bob Johnson', 'Engineering', 80000),
(4, 'Alice Williams', 'Marketing', 70000),
(5, 'Chris Evans', 'Sales', 55000);

Use: https://www.freemysqlhosting.net/account/ MySQL







