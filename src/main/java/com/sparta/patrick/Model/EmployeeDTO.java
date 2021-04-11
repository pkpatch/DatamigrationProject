package com.sparta.patrick.Model;

import java.sql.Date;
import java.util.Objects;

public class EmployeeDTO {

    private int empID;
    private String namePrefix;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private char gender;
    private String eMail;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private int salary;

    public EmployeeDTO(int employeeId, String namePrefix, String firstName, char middleInitial, String lastName, char gender, String email, Date dateOfBirth, Date dateOfJoining, int salary) {
        this.empID = employeeId;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.eMail = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return empID == that.empID && middleInitial == that.middleInitial && gender == that.gender && salary == that.salary && Objects.equals(namePrefix, that.namePrefix) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(eMail, that.eMail) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(dateOfJoining, that.dateOfJoining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, namePrefix, firstName, middleInitial, lastName, gender, eMail, dateOfBirth, dateOfJoining, salary);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return eMail;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        salary = salary;
    }

}
