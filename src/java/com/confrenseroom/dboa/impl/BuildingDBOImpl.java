package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Building;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class BuildingDBOImpl implements CRUD<Building> {

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public boolean create(Building b) {
        boolean isCreated = false;
        try {
            ps = DBConnector.getpStament("INSERT INTO BUILDING(name)VALUES(?)");
            ps.setString(1, b.getBuildingName());
            isCreated = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return isCreated;
    }

    @Override
    public Building read(String name) {
        Building bld = null;
        try {
            String sqlstatement = "SELECT * FROM BUILDING WHERE NAME=?";
            ps = DBConnector.getpStament(sqlstatement);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                bld = new Building(rs.getInt(1), rs.getString(2));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return bld;
    }

    @Override
    public boolean update(Building bld) {
        boolean updated = false;
        String statment = "update building set buildID=?, name=? where name=?";
        try {
            ps = DBConnector.getpStament(statment);
            ps.setInt(1, bld.getId());
            ps.setString(2, bld.getBuildingName());
            ps.setString(3, bld.getBuildingName());
            updated = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return updated;
    }

    @Override
    public boolean delete(String name) {
        boolean deleted = false;
        try {
            String sql = "DELETE FROM BUILDING where name=?";
            ps = DBConnector.getpStament(sql);
            ps.setString(1, name);
            deleted = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return deleted;
    }

    @Override
    public List<Building> list() {
        List<Building> blist = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sqlstatement = "SELECT * FROM BUILDING";
            rs = DBConnector.getpStament(sqlstatement).executeQuery();
            while (rs.next()) {
                Building bld = new Building(rs.getInt(1), rs.getString(2));
                blist.add(bld);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return blist;
    }

    @Override
    public Building readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LinkedList<Building> listLinked() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
