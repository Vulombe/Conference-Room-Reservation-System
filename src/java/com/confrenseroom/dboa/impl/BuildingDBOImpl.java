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

    @Override
    public boolean create(Building b) {
        boolean isCreated = false;
        try {
            PreparedStatement ps = DBConnector.getpStament("INSERT INTO BUILDING(name,roomID)VALUES(?,?)");
            ps.setString(1, b.getBuildingName());
            ps.setInt(2, b.getRoomID());

            if (ps.executeUpdate() > 1) {
                isCreated = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return isCreated;
    }

    @Override
    public Building read(String name) {
        Building b = null;
        return b;
    }

    @Override
    public Building update(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Building> list() {
        List<Building> blist = new ArrayList<>();
        try {
            String sqlstatement = "SELECT * FROM BUILDING";
            ResultSet rs = DBConnector.getpStament(sqlstatement).executeQuery();
            while(rs.next())
            {
                Building bld = new Building(rs.getString(2),rs.getInt(3));
                blist.add(bld);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return blist;
    }

}
