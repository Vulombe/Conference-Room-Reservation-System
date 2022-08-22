package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Equipment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class EquipmentDBOImpl implements CRUD<Equipment> {

    @Override
    public boolean create(Equipment e) {
        boolean isCreated = false;
        try {
           PreparedStatement ps = DBConnector.getpStament("INSERT INTO EQUIPMENT(name)VALUES(?)");
            ps.setString(1, e.getEquipmntName());
           if(ps.executeUpdate()>1)
               isCreated = true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return isCreated;
    }

    @Override
    public Equipment read(String name) {
           Equipment eqmnt = null;
        try {
            String sqlstatement = "SELECT * FROM EQUIPMENT";
            ResultSet rs = DBConnector.getpStament(sqlstatement).executeQuery();
            if(rs.next())
            {
                 eqmnt = new Equipment(rs.getInt(1),rs.getString(2));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return eqmnt;
    }

    @Override
    public Equipment update(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Equipment> list() {
           List<Equipment> elist = new ArrayList<>();
        try {
            String sqlstatement = "SELECT * FROM EQUIPMENT";
            ResultSet rs = DBConnector.getpStament(sqlstatement).executeQuery();
            while(rs.next())
            {
                Equipment eqmnt = new Equipment(rs.getInt(1),rs.getString(2));
                elist.add(eqmnt);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return elist;
    }
    
}
