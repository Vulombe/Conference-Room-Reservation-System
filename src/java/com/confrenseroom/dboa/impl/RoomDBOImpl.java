package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Room;
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
public class RoomDBOImpl implements CRUD<Room> {

    @Override
    public boolean create(Room r) {
        boolean isCreated = false;
        try {
            PreparedStatement ps = DBConnector.getpStament("INSERT INTO ROOM(name,capacity,status,equipID)VALUES(?,?,?,?)");
            ps.setString(1, r.getRoomName());
            ps.setInt(2, r.getCapacity());
            ps.setString(3, r.getStatus().toString());
            ps.setInt(4, r.getEquipmentID());
            if (ps.executeUpdate() > 1) {
                isCreated = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return isCreated;

    }

    @Override
    public Room read(String name) {
         Room room = null;
        try {
            String sqlstatement = "SELECT * FROM ROOM";
            ResultSet rs = DBConnector.getpStament(sqlstatement).executeQuery();
            if(rs.next())
            {
                String roomName = rs.getString(2);
                int capacity= rs.getInt(3);
                Status status;
                String getstatus = rs.getString(4);
                if(getstatus.equalsIgnoreCase("AVAILABLE"))
                {
                    status = Status.AVAILABLE;
                }else
                {
                    status = Status.NOTAVAILABLE;
                }
                int equipmentID = rs.getInt(5);
                 room = new Room(roomName,capacity,status,equipmentID);
             
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return room;
    }

    @Override
    public Room update(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Room> list() {
              List<Room> rlist = new ArrayList<>();
        try {
            String sqlstatement = "SELECT * FROM ROOM";
            ResultSet rs = DBConnector.getpStament(sqlstatement).executeQuery();
            while(rs.next())
            {
                //Room(
                String roomName = rs.getString(2);
                int capacity= rs.getInt(3);
                Status status;
                String getstatus = rs.getString(4);
                if(getstatus.equalsIgnoreCase("AVAILABLE"))
                {
                    status = Status.AVAILABLE;
                }else
                {
                    status = Status.NOTAVAILABLE;
                }
                int equipmentID = rs.getInt(5);
                Room room = new Room(roomName,capacity,status,equipmentID);
                rlist.add(room);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rlist;
    }

}
