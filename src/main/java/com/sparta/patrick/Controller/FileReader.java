package com.sparta.patrick.Controller;

import com.sparta.patrick.Model.EmployeeDTO;
import com.sparta.patrick.utils.Printer;
import com.sparta.patrick.utils.myTimer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static com.sparta.patrick.App.logger;

public class FileReader implements Runnable{
    String inputFile;

    @Override
    public void run() {
        readFile();
    }

    public FileReader(String file) {
        inputFile = file;
    }

    public void readFile() {

        String[] employeeData;
        Map<Integer, EmployeeDTO> employees = new HashMap<>();
        Map<Integer, EmployeeDTO> duplicateEmployees = new HashMap<>();

        DataFormatter dataFormatter = new DataFormatter();
        EmployeeManager employeeManager = new EmployeeManager();

        long start = System.nanoTime();
        logger.info("Reading File:: " + inputFile);
        int i = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(inputFile))) {
            String line;
            bufferedReader.readLine();
            logger.info("Begin Data Validation:: ");
            while ((line = bufferedReader.readLine()) != null) {
                employeeData = line.split("\\,");

                EmployeeDTO employeeDTO = dataFormatter.fileLineToDTO(employeeData);

                if (employees.containsKey(employeeDTO.getEmpID())) {
                    duplicateEmployees.put(employeeDTO.getEmpID(), employeeDTO);
                } else {
                    employees.put(employeeDTO.getEmpID(), employeeDTO);
                }
            }
        } catch (FileNotFoundException e) {
            Printer.printMessage("Error: Please see log for further information");
            logger.error("Error");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long finish = System.nanoTime();

        int records = employees.size() + duplicateEmployees.size();

        myTimer.time(records +  " records were read from the file ",start, finish, records);

        String tableName = "employees"+records;

        employeeManager.mapEmployeesToDB(employees, tableName);
        if(duplicateEmployees.size() >0){
            tableName = "duplicates" + tableName;
            employeeManager.mapEmployeesToDB(duplicateEmployees, tableName);
        }
    }
}
