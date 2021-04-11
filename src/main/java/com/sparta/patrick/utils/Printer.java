package com.sparta.patrick.utils;

import com.sparta.patrick.Model.EmployeeDTO;

public class Printer {

    public static void printMessage(String string) {
        System.out.println(string);
    }

    public static void printEmployee(EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO.getNamePrefix() + " " + employeeDTO.getFirstName() + " " + employeeDTO.getLastName());
    }
}
