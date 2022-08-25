package com.confrenseroom.model;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class Employee {

    private String empID;
    private String fullName;
    private String tittle;
    private String department;
    private String cellNumber;

    public Employee(String empID, String fullName, String tittle, String department, String cellNumber) {
        this.empID = empID;
        this.fullName = fullName;
        this.tittle = tittle;
        this.department = department;
        this.cellNumber = cellNumber;
    }

    public Employee(String fullName, String tittle, String department, String cellNumber) {
        this.fullName = fullName;
        this.tittle = tittle;
        this.department = department;
        this.cellNumber = cellNumber;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + ", fullName=" + fullName + ", tittle=" + tittle + ", department=" + department + ", cellNumber=" + cellNumber + '}';
    }
 
}
