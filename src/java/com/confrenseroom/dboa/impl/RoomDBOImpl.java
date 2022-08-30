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

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public boolean create(Room r) {
        boolean isCreated = false;
        try {
            ps = DBConnector.getpStament("INSERT INTO ROOM(name,capacity,status,buildID)VALUES(?,?,?,102)");
            ps.setString(1, r.getRoomName());
            ps.setInt(2, r.getCapacity());
            ps.setString(3, r.getStatus().toString());
            isCreated = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return isCreated;

    }

    @Override
    public Room read(String name) {
        Room room = null;
        try {
            String sqlstatement = "SELECT * FROM ROOM WHERE NAME=?";
            ps = DBConnector.getpStament(sqlstatement);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                int roomID = rs.getInt(1);
                String roomName = rs.getString(2);
                int capacity = rs.getInt(3);
                Status status;
                String getstatus = rs.getString(4);
                int bldID = rs.getInt(5);
                if (getstatus.equalsIgnoreCase("AVAILABLE")) {
                    status = Status.AVAILABLE;
                } else {
                    status = Status.NOTAVAILABLE;
                }
                room = new Room(roomID, roomName, capacity, bldID, status);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return room;
    }

    @Override
    public boolean update(Room room) {
        boolean updated = false;
        String statment = "update room set roomID=?, name=?, capacity=?, status=? where name=?";
        try {
            ps = DBConnector.getpStament(statment);
            ps.setInt(1, room.getRoomID());
            ps.setString(2, room.getRoomName());
            ps.setInt(3, room.getCapacity());
            ps.setString(4, room.getStatus().toString());
            ps.setString(5, room.getRoomName());
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
            String sql = "DELETE FROM ROOM where name=?";
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
    public List<Room> list() {
        List<Room> rlist = new ArrayList<>();
        try {
            String sqlstatement = "SELECT * FROM ROOM";
            rs = DBConnector.getpStament(sqlstatement).executeQuery();
            while (rs.next()) {
                int roomID = rs.getInt(1);
                String roomName = rs.getString(2);
                int capacity = rs.getInt(3);
                Status status;
                String getstatus = rs.getString(4);
                int bldID = rs.getInt(5);
                if (getstatus.equalsIgnoreCase("AVAILABLE")) {
                    status = Status.AVAILABLE;
                } else {
                    status = Status.NOTAVAILABLE;
                }
                Room room = new Room(roomID, roomName, capacity, bldID, status);
                rlist.add(room);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return rlist;
    }

    @Override
    public Room readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
