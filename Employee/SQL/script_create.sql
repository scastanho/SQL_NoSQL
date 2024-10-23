-- Criando a tabela Employees
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,          -- Chave primária, campo inteiro para identificação
    Name VARCHAR(100) NOT NULL,          -- Nome do funcionário, campo de texto (100 caracteres no máximo)
    Department VARCHAR(50) NOT NULL,     -- Departamento do funcionário, campo de texto (50 caracteres no máximo)
    Salary DECIMAL(10, 2) NOT NULL       -- Salário do funcionário, valor decimal com 2 casas decimais
);

-- Inserindo os dados na tabela Employees
INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES 
(1, 'John Smith', 'Engineering', 75000),
(2, 'Eric Hemsworth', 'Marketing', 65000),
(3, 'Bob Johnson', 'Engineering', 80000),
(4, 'Alice Williams', 'Marketing', 70000),
(5, 'Chris Evans', 'Sales', 55000);


https://www.freemysqlhosting.net/account/
sql3.freemysqlhosting.net	sql3739987	sql3739987 3306


EmployTable

EmployeeID,Name,Department,Salary
1,John Smith,Engineering,75000
2,Eric Hemsworth,Marketing,65000
3,Bob Johnson,Engineering,80000
4,Alice Williams,Marketing,70000
5,Chris Evans,Sales,55000

Select Department,Salary from EmployTable
where (formula here to calc avarage) 

or

in the class we can calculate de avarage data from select
(formula here to calc avarage)

Data Eng Pipeline

Considerations to make a file based data engineering pipeline reliable and fault tolerant.


Hi

Your account number is: 993329

Your new database is now ready to use.

To connect to your database use these details

Server: sql3.freemysqlhosting.net
Name: sql3739987
Username: sql3739987
Password: RCY3Bjhukx
Port number: 3306


