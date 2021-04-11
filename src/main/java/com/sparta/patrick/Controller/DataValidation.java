package com.sparta.patrick.Controller;

import java.sql.Date;
import java.time.LocalDate;

import static com.sparta.patrick.App.logger;

public class DataValidation {

    public int checkEmpIdAndSalary(int empIdSalary) {
        if (empIdSalary <= 0) {
            return 0;
        }
        return empIdSalary;
    }

    public String checkNamePrefix(String prefix) {
        if (!(prefix.equals("Mr.") || prefix.equals("Mrs.") || prefix.equals("Ms.") || prefix.equals("Miss.") || prefix.equals("Dr.") || prefix.equals("Drs.") || prefix.equals("Hon.") || prefix.equals("Prof."))) {
            return "NOPREFIX";
        }
        return prefix;
    }

    public String checkName(String name) {
        if ((name == null) && (name.equals("")) && (!name.matches("^[a-zA-Z]"))) {
            return "INVALID_NAME";
        }
        return name;
    }

    public char checkMiddleName(char initial) {
        String middle = String.valueOf(initial);
        if (middle.length() > 1) {
            initial = '!';
            return initial;
        }
        return initial;
    }

    public char checkGender(char gender) {
        if (!(gender == 'M' || gender == 'F')) {
            gender = '!';
            return gender;
        }
        return gender;
    }

    public String checkEmail(String email) {
        return email;
    }

    public Date checkDate(String employeeDatum) {
        try {
            String[] employeeDate = employeeDatum.split("/");
            int month = (Integer.parseInt(employeeDate[0]));
            int day = (Integer.parseInt(employeeDate[1]));
            int year = (Integer.parseInt(employeeDate[2]));

            LocalDate localDate = LocalDate.of(year, month, day);
            Date date = Date.valueOf(localDate);
            return date;

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
