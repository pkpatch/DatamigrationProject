package com.sparta.patrick.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import static com.sparta.patrick.App.logger;

public class EmployeeDAO {

    private final String URL = "jdbc:mysql://localhost:3306/patrick?serverTimerzone=GMT";
    private Connection connection;

    private Connection connectToDatabase() {
        try {
            connection = DriverManager.getConnection(URL, System.getenv("java_username"), System.getenv("java_password"));
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return connection;
    }

    public void dropEmployeeTable(String tableName) {
        String dropEmployeesTable = "DROP TABLE  IF EXISTS " + tableName + ";";
        try (PreparedStatement preparedStatement = connectToDatabase().prepareStatement(dropEmployeesTable)) {
            boolean hasRun = preparedStatement.execute();

            if (hasRun) {
                logger.error("Drop unsuccessful");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    public void createEmployeeTable(String tableName) {
        String createEmployeesTable = "CREATE TABLE " + tableName + "(emp_id INTEGER PRIMARY KEY UNIQUE,name_prefix VARCHAR(5),first_name VARCHAR(255),middle_initial CHAR(1), last_name VARCHAR(255),gender CHAR(1),email VARCHAR(255),date_of_birth DATE,date_of_joining DATE,salary INTEGER);";

        try (PreparedStatement preparedStatement = connectToDatabase().prepareStatement(createEmployeesTable)) {
            boolean hasRun = preparedStatement.execute();
            if (hasRun) {
                logger.error("Create unsuccessful");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());

        }
    }

    public void insertEmployee(Map<Integer, EmployeeDTO> employees, String tableName) {
        String insertEmployeesUsingParams = "INSERT INTO " + tableName + "(emp_id, name_prefix,first_name,middle_initial ,last_name, gender , email , date_of_birth , date_of_joining , salary) VALUES (?,?,?,?,?,?,?,?,?,?);";

        try (PreparedStatement preparedStatement = connectToDatabase().prepareStatement(insertEmployeesUsingParams)) {

            for (Integer key : employees.keySet()) {
                EmployeeDTO employeeDTO = employees.get(key);
                preparedStatement.setInt(1, employeeDTO.getEmpID());
                preparedStatement.setString(2, employeeDTO.getNamePrefix());
                preparedStatement.setString(3, employeeDTO.getFirstName());
                preparedStatement.setString(4, String.valueOf(employeeDTO.getMiddleInitial()));
                preparedStatement.setString(5, employeeDTO.getLastName());
                preparedStatement.setString(6, String.valueOf(employeeDTO.getGender()));
                preparedStatement.setString(7, employeeDTO.getEmail());
                preparedStatement.setDate(8, employeeDTO.getDateOfBirth());
                preparedStatement.setDate(9, employeeDTO.getDateOfJoining());
                preparedStatement.setInt(10, employeeDTO.getSalary());
                preparedStatement.addBatch();
            }
            int[] hasRun = preparedStatement.executeBatch();

            if (!(hasRun.length > 0)) {
                logger.error("Update unsuccessful");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
