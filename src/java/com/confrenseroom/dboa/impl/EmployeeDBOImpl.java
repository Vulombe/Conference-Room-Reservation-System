package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class EmployeeDBOImpl implements CRUD<Employee> {

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    
    @Override
    public boolean create(Employee e) {
        boolean isCreated = false;
        try {
            ps = DBConnector.getpStament("INSERT INTO EMPLOYEE(empID,fullname,title,department,cellnumber)VALUES(?,?,?,?,?)");
            ps.setString(1, e.getEmpID());
            ps.setString(2, e.getFullName());
            ps.setString(3, e.getTittle());
            ps.setString(4, e.getDepartment());
            ps.setString(5, e.getCellNumber());
            isCreated = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return isCreated;
    }

    @Override
    public Employee read(String id) {
        Employee emp = null;
        try {
            String sqlstatement = "SELECT * FROM EMPLOYEE WHERE EMPID=?";
            ps = DBConnector.getpStament(sqlstatement);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String empID = rs.getString(1);
                String fullName = rs.getString(2);
                String title = rs.getString(3);
                String department = rs.getString(4);
                String cellNumber = rs.getString(5);

                emp = new Employee(empID, fullName, title, department, cellNumber);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return emp;
    }

    @Override
    public boolean update(Employee e) {
        boolean updated = false;
        String statment = "update employee set empID=?, fullname=?,title=?, department=?,cellnumber=? where empID=?";
        try {
            ps = DBConnector.getpStament(statment);
            ps.setString(1, e.getEmpID());
            ps.setString(2, e.getFullName());
            ps.setString(3, e.getTittle());
            ps.setString(4, e.getDepartment());
            ps.setString(5, e.getCellNumber());
            ps.setString(6, e.getEmpID());
            updated = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return updated;
    }

    @Override
    public boolean delete(String id) {
        boolean deleted = false;
        try {
            String sql = "DELETE FROM EMPLOYEE where empID=?";
            ps = DBConnector.getpStament(sql);
            ps.setString(1, id);
            deleted = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return deleted;
    }

    @Override
    public List<Employee> list() {
        List<Employee> ulist = new ArrayList<>();
        try {
            String sqlstatement = "SELECT * FROM USER";
            rs = DBConnector.getpStament(sqlstatement).executeQuery();
            while (rs.next()) {
                String empID = rs.getString(1);
                String fullName = rs.getString(2);
                String title = rs.getString(3);
                String department = rs.getString(4);
                String cellNumber = rs.getString(5);
                Employee emp = new Employee(empID, fullName, title, department, cellNumber);
                ulist.add(emp);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return ulist;
    }

    @Override
    public Employee readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
