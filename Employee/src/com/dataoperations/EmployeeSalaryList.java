package com.dataoperations;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmployeeSalaryList extends Connections {

	static NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
		
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // getConnection to MySQL Online
        try (Connection connection = DriverManager.getConnection(DBURI, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM Employees";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("EmployeeID");
                String name = resultSet.getString("Name");
                String department = resultSet.getString("Department");
                double salary = resultSet.getDouble("Salary");
                employees.add(new Employee(employeeId, name, department, salary));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        double averageSalary = calculateAverageSalary(employees);
        System.out.println("-------------------------------");
        //System.out.printf("\nThe average salary is: %-10s%n", averageSalary);
        System.out.printf("\nThe average salary is: %-10s%n", numberFormat.format(averageSalary)); 
    }

    private static double calculateAverageSalary(List<Employee> employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
        	
        	try {
				System.out.printf("%-20s | %-10s%n", employee.getName(), numberFormat.format(employee.getSalary()));
			} catch (Exception e) {
				// Average Salary Exception.
				e.printStackTrace();
			}
        	//System.out.printf("%-20s | %.2f%n", employee.getName(), employee.getSalary());
        	//System.out.println("Employee: " + employee.getName()+ " | "+employee.getSalary()); 
            totalSalary += employee.getSalary();
        }
        return employees.isEmpty() ? 0 : totalSalary / employees.size(); // Verifica se a lista não está vazia
    }
}
