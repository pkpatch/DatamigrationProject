package com.sparta.patrick;

import com.sparta.patrick.Controller.DataFormatter;
import com.sparta.patrick.Model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.time.LocalDate;

public class EmployeeTest {

    @Test
    public void shouldCreateEmployee(){
        DataFormatter dataFormatter = new DataFormatter();

        String[] employeeData = {"1","Mr.","Patrick","K","Walsh","M","Pat@gmail.com","01/25/1993","03/08/2020","23000"};

        LocalDate ldate1 = LocalDate.parse("1993-01-25");
        Date date1 = Date.valueOf(ldate1);

        LocalDate ldate2 = LocalDate.parse("2020-03-08");
        Date date2 = Date.valueOf(ldate2);

        try {
            Assertions.assertEquals(
                new EmployeeDTO(1,"Mr.","Patrick",'K',"Walsh",'M',"Pat@gmail.com", date1, date2,23000),
                dataFormatter.fileLineToDTO(employeeData)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
