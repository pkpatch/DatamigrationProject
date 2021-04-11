package com.sparta.patrick.Controller;

import com.sparta.patrick.Model.EmployeeDAO;
import com.sparta.patrick.Model.EmployeeDTO;
import com.sparta.patrick.utils.myTimer;

import java.util.Map;

public class EmployeeManager {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    public void mapEmployeesToDB(Map<Integer, EmployeeDTO> employees, String tableName) {
        employeeDAO.dropEmployeeTable(tableName);
        employeeDAO.createEmployeeTable(tableName);

        long start = System.nanoTime();
        employeeDAO.insertEmployee(employees, tableName);
        long finish = System.nanoTime();

        myTimer.time(employees.size() + " records inserted into employees table", start, finish, employees.size());
    }
}
