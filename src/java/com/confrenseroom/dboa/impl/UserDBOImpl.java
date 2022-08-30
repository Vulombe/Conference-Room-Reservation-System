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

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public boolean create(User u) {
        boolean isCreated = false;
        try {
            ps = DBConnector.getpStament("INSERT INTO USER(userid,firstname,lastname,department,"
                    + "cellnumber, emailaddress, password)VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, u.getUserID());
            ps.setString(2, u.getFirstname());
            ps.setString(3, u.getLastname());
            ps.setString(4, u.getDepartment());
            ps.setString(5, u.getCellNumber());
            ps.setString(6, u.getEmailaddress());
            ps.setString(7, u.getPassword());
            isCreated = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return isCreated;
    }

    @Override
    public User read(String email) {
        User user = null;
        try {
            String sqlstatement = "SELECT * FROM USER WHERE EMAILADDRESS=?";
            ps = DBConnector.getpStament(sqlstatement);
            ps.setString(1, email);
            rs = ps.executeQuery();
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
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean updated = false;
        String statment = "update user set userid=?, firstname=?,lastname=?, department=?,cellnumber=?, emailaddress=?,password=? where emailaddress=?";
        try {
            ps = DBConnector.getpStament(statment);
            ps.setString(1, user.getUserID());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getDepartment());
            ps.setString(5, user.getCellNumber());
            ps.setString(6, user.getEmailaddress());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getEmailaddress());
            updated = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return updated;
    }

    @Override
    public boolean delete(String email) {
        boolean deleted = false;
        try {
            String sql = "DELETE FROM USER where emailaddress=?";
            ps = DBConnector.getpStament(sql);
            ps.setString(1, email);
            deleted = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return deleted;
    }

    @Override
    public List<User> list() {
        List<User> ulist = new ArrayList<>();
        try {
            String sqlstatement = "SELECT * FROM USER";
            rs = DBConnector.getpStament(sqlstatement).executeQuery();
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
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return ulist;
    }

    @Override
    public User readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
