package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Building;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class BuildingDBOImpl implements CRUD<Building> {

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public BuildingDBOImpl() {
    }

    @Override
    public boolean create(Building b) {
        boolean isCreated = false;
        try {
            ps = DBConnector.getpStament("INSERT INTO BUILDING(name,roomID)VALUES(?,?)");
            ps.setString(1, b.getBuildingName());
            ps.setInt(2, b.getRoomID());
            if (ps.executeUpdate() > 1) {
                isCreated = true;
            }
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
            String sqlstatement = "SELECT * FROM BUILDING";
            rs = DBConnector.getpStament(sqlstatement).executeQuery();
            if (rs.next()) {
                bld = new Building(rs.getString(2), rs.getInt(3));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return bld;
    }

    @Override
    public boolean update(Building name) {
        boolean updated = false;
        String statment = "update building set ID=?, name=?,roomID=? where name=?";
        try {
            ps = DBConnector.getpStament(statment);
            ps.setInt(1, name.getId());
            ps.setString(2, name.getBuildingName());
            ps.setInt(3, name.getRoomID());
            ps.setString(4, name.getBuildingName());
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
                Building bld = new Building(rs.getString(2), rs.getInt(3));
                blist.add(bld);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }

        return blist;
    }

}
