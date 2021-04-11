package com.sparta.patrick.Controller;

import com.sparta.patrick.Model.EmployeeDTO;

import java.sql.Date;
import java.text.ParseException;

import static com.sparta.patrick.App.logger;

public class DataFormatter {

    public EmployeeDTO fileLineToDTO(String[] employeeData) throws ParseException {

        DataValidation dataValidation = new DataValidation();

        int employeeId = dataValidation.checkEmpIdAndSalary(Integer.parseInt(employeeData[0]));
        String namePrefix = dataValidation.checkNamePrefix(employeeData[1]);
        String firstName = dataValidation.checkName(employeeData[2]);
        char middleInitial = dataValidation.checkMiddleName(employeeData[3].charAt(0));
        String lastName = dataValidation.checkName(employeeData[4]);
        char gender = dataValidation.checkGender(employeeData[5].charAt(0));
        String email = dataValidation.checkEmail(employeeData[6]);
        Date dateOfBirth = dataValidation.checkDate(employeeData[7]);
        Date dateOfJoining = dataValidation.checkDate(employeeData[8]);
        int salary = dataValidation.checkEmpIdAndSalary(Integer.parseInt(employeeData[9]));

        EmployeeDTO employeeDTO = new EmployeeDTO(employeeId, namePrefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary);

        logValidationResults(employeeDTO);

        return employeeDTO;

    }

    private void logValidationResults(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmpID() == 0 || employeeDTO.getSalary() == 0) {
            logger.warn(employeeDTO.getFirstName() + " " + employeeDTO.getLastName() + " invalid data has been entered for columns Employee id and/or Salary");
        }

        if (employeeDTO.getNamePrefix() == "NOPREFIX") {
            logger.warn(employeeDTO.getFirstName() + " " + employeeDTO.getLastName() + " invalid data has been entered for Prefix column");
        }

        if (employeeDTO.getFirstName().equals("INVALID_NAME") || employeeDTO.getLastName().equals("INVALID_NAME")) {
            logger.warn("Id:: " + employeeDTO.getEmpID() + " Have enter invalid details for first/last name");
        }

        if (String.valueOf(employeeDTO.getGender()).equals("!") || String.valueOf(employeeDTO.getMiddleInitial()).equals("!")) {
            logger.warn("ID:: " + employeeDTO.getEmpID() + " " + employeeDTO.getFirstName() + " " + employeeDTO.getLastName() + " invalid data has been entered for Gender / Middle Initial");
        }

        if (employeeDTO.getDateOfBirth() == null || employeeDTO.getDateOfJoining() == null) {
            logger.warn("ID:: " + employeeDTO.getEmpID() + " " + employeeDTO.getFirstName() + " " + employeeDTO.getLastName() + " invalid data has been entered for Date of Join or Date oof Birth");
        }
    }
}