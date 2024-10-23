# SQL or NoSQL DATA PERSISTENCE

## This project example aims to present two ways of storing employee data.

1- Via SQL.
2- Via NoSQL.

Look at the Java code. You can find both ways.

## Tips:
Import this project "Employee" into your Eclipse IDE with Maven format. Use JDK 11 or 17.
To use the EmployeeSalaryList class[1], run the scripts below first on your MySQL database. 

## Classes: 
1-EmployeeSalaryList.java | List data from the Employee table via SQL in MySQL.
2-DynamoDBLocalExample.java | Creates a table in AWS DynamoDB.
[To use DynamoDB Locally on Windows install the application first before running the java example.]
URL DynamoDBLocal Download:  https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html
To run DynamoDB v2.5.X or greater on your computer, you must have the Java Runtime Environment (JRE) version 17.x or newer. 
The application doesn't run on earlier JRE versions.

## Create file: "C:\Users\YOUR_USER\.aws\credentials.txt"
Insert 2 lines below:
aws_access_key_id = dummyAccessKey
aws_secret_access_key = dummySecretKey


## Use an SQL tool like DBeaver free or others, to create the database in MySQL OnLine for example.
Script SQL to create mysql tables from the command below:

-- Scripts to create table Employees
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY, -- Primary key, integer field for identification
    Name VARCHAR(100) NOT NULL, -- Employee name, text field (100 characters max)
    Department VARCHAR(50) NOT NULL, -- Employee department, text field (50 characters max)
    Salary DECIMAL(10, 2) NOT NULL -- Employee salary, decimal value with 2 decimal places
);

-- Insert data in Employees
INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES 
(1, 'John Smith', 'Engineering', 75000),
(2, 'Eric Hemsworth', 'Marketing', 65000),
(3, 'Bob Johnson', 'Engineering', 80000),
(4, 'Alice Williams', 'Marketing', 70000),
(5, 'Chris Evans', 'Sales', 55000);

## Good luck. If you have any questions, write to me.
E-mail: scastanho@gmail.com


