package com.confrenseroom.model;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class User {
    private String userID;
    private String firstname;
    private String lastname;
    private String department;
    private String cellNumber;
    private String emailaddress;
    private String password;

    public User(String userID, String firstname, String lastname, String department, String cellNumber, String emailaddress, String password) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.cellNumber = cellNumber;
        this.emailaddress = emailaddress;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", firstname=" + firstname + ", lastname=" + lastname + ", department=" + department + ", cellNumber=" + cellNumber + ", emailaddress=" + emailaddress + ", password=" + password + '}';
    }
    
    
}
