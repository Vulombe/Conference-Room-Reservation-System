package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Equipment;
import com.confrenseroom.model.Status;
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

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public boolean create(Equipment e) {
        boolean isCreated = false;
        try {
            ps = DBConnector.getpStament("INSERT INTO EQUIPMENT(name)VALUES(?)");
            ps.setString(1, e.getEquipmntName());
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
    public Equipment read(String name) {
        Equipment eqmnt = null;
        try {
            Status status;
            String sqlstatement = "SELECT * FROM EQUIPMENT";
            rs = DBConnector.getpStament(sqlstatement).executeQuery();
            if (rs.next()) {
                if (rs.getString(3).equalsIgnoreCase("available")) {
                    status = Status.AVAILABLE;
                } else {
                    status = Status.NOTAVAILABLE;
                }
                eqmnt = new Equipment(rs.getInt(1), rs.getString(2), status);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return eqmnt;
    }

    @Override
    public boolean update(Equipment eqpmnt) {
        boolean updated = false;
        String statment = "update equipment set equipID=?, name=? where name=?";
        try {
            ps = DBConnector.getpStament(statment);
            ps.setInt(1, eqpmnt.getEquipmentID());
            ps.setString(2, eqpmnt.getEquipmntName());
            ps.setString(3, eqpmnt.getEquipmntName());
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
            String sql = "DELETE FROM EQUIPMENT where name=?";
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
    public List<Equipment> list() {
        List<Equipment> elist = new ArrayList<>();
        try {
            Status status;
            Equipment eqmnt;
            String sqlstatement = "SELECT * FROM EQUIPMENT";
            rs = DBConnector.getpStament(sqlstatement).executeQuery();
            while (rs.next()) {
                if (rs.getString(3).equalsIgnoreCase("available")) {
                    status = Status.AVAILABLE;
                } else {
                    status = Status.NOTAVAILABLE;
                }
                eqmnt = new Equipment(rs.getInt(1), rs.getString(2), status);
                elist.add(eqmnt);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return elist;
    }

}
