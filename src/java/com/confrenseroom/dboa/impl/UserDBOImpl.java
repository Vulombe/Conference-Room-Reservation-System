package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class UserDBOImpl implements CRUD<User> {

    @Override
    public boolean create(User u) {
        boolean isCreated = false;
        try {
            PreparedStatement ps = DBConnector.getpStament("INSERT INTO USER(userid,firstname,lastname,department,"
                    + "cellnumber, emailaddress, password)VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, u.getUserID());
            ps.setString(2, u.getFirstname());
            ps.setString(3, u.getLastname());
            ps.setString(4, u.getDepartment());
            ps.setString(5, u.getCellNumber());
            ps.setString(6, u.getEmailaddress());
            ps.setString(7, u.getPassword());
            if (ps.executeUpdate() > 1) {
                isCreated = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return isCreated;
    }

    @Override
    public User read(String email) {
        User user = null;
        try {
            String sqlstatement = "SELECT * FROM USER WHERE EMAILADDRESS=?";
            PreparedStatement ps = DBConnector.getpStament(sqlstatement);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                String userID = rs.getString(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String department = rs.getString(4);
                String cellNumber = rs.getString(5);
                String emailaddress = rs.getString(6);
                String password = rs.getString(7);
                user = new User(userID, firstname, lastname, department, cellNumber, emailaddress, password);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public User update(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> list() {
        List<User> ulist = new ArrayList<>();
        try {
            String sqlstatement = "SELECT * FROM USER";
            ResultSet rs = DBConnector.getpStament(sqlstatement).executeQuery();
            while (rs.next()) {
                String userID = rs.getString(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String department = rs.getString(4);
                String cellNumber = rs.getString(5);
                String emailaddress = rs.getString(6);
                String password = rs.getString(7);
                User user = new User(userID, firstname, lastname, department, cellNumber, emailaddress, password);

                ulist.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ulist;
    }

}
