package com.dataoperations;

import java.sql.*;

public class EmployeeSalaryAverageTest extends Connections {
    
    
    public static void main(String[] args) {
    	
    	System.out.println("The EmployeeSalaryAverage START...\n"+DBURI);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(DBURI, USER, PASSWORD);
            
            // SQL query to calculate the average salary
            String sql = "SELECT AVG(Salary) AS MediaSalario FROM Employees";
            // Prepare the SQL statement
            preparedStatement = connection.prepareStatement(sql);
            
            // Execute the query
            resultSet = preparedStatement.executeQuery();
            
            // Process the result
            if (resultSet.next()) {
                double averageSalary = resultSet.getDouble("MediaSalario");
                System.out.println("The average salary of employees is: " + averageSalary);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
