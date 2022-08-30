package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Meeting;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class MeetingDBOImpl implements CRUD<Meeting> {

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public boolean create(Meeting t) {
        boolean created = false;
        try {
            String statement = "insert into MEETING(meetingdate,starttime,endtime,attendies,roomID,empID)VALUES(?,?,?,?,?,?)";
            ps = DBConnector.getpStament(statement);

            Date date = Date.valueOf(t.getDate());
            Time sT = Time.valueOf(t.getStartTime());
            Time eT = Time.valueOf(t.getEndTime());
            ps.setDate(1, date);
            ps.setTime(2, sT);
            ps.setTime(3, eT);
            ps.setInt(4, t.getAttendies());
            ps.setInt(5, t.getRoomID());
            ps.setString(6, t.getEmpID());
            created = ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return created;
    }

    @Override
    public Meeting readById(int id) {
        Meeting meeting = null;
        try {
            String statement = "SELECT * FROM MEETING where meetID=?";
            ps = DBConnector.getpStament(statement);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int mid = rs.getInt(1);
                LocalDate date = rs.getDate(2).toLocalDate();
                LocalTime startTime = rs.getTime(3).toLocalTime();
                LocalTime endTime = rs.getTime(4).toLocalTime();
                int attendies = rs.getInt(5);
                int roomID = rs.getInt(6);
                String empID = rs.getString(7);
                meeting = new Meeting(mid, date, startTime, endTime, attendies, roomID, empID);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return meeting;
    }

    @Override
    public boolean update(Meeting mt) {
        boolean update = false;
        try {
            String pStatement = "UPDATE MEETING SET meetID=?,meetingdate=?,starttime=?,endtime = ?,attendies=?,roomID=?,empID = ? where meetID = ?";
            ps = DBConnector.getpStament(pStatement);
            Date date = Date.valueOf(mt.getDate());
            Time sT = Time.valueOf(mt.getStartTime());
            Time eT = Time.valueOf(mt.getEndTime());
            ps.setInt(1, mt.getMeetID());
            ps.setDate(2, date);
            ps.setTime(3, sT);
            ps.setTime(4, eT);
            ps.setInt(5, mt.getAttendies());
            ps.setInt(6, mt.getRoomID());
            ps.setString(7, mt.getEmpID());
            ps.setInt(8, mt.getMeetID());
            update = ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return update;
    }

    @Override
    public boolean delete(String name) {
        boolean delete = false;
        return delete;
    }

    public boolean delete(int id) {
        boolean delete = false;
        try {
            String statement = "DELETE FROM MEETING where meetID = ?";
            ps = DBConnector.getpStament(statement);
            ps.setInt(1, id);
            delete = ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException ex) {
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return delete;
    }

    @Override
    public List<Meeting> list() {
        List<Meeting> mList = new ArrayList<>();
        try {
            String statement = "SELECT * FROM MEETING";
            ps = DBConnector.getpStament(statement);
            rs = ps.executeQuery();
            if (rs.next()) {
                int mid = rs.getInt(1);
                LocalDate date = rs.getDate(2).toLocalDate();
                LocalTime startTime = rs.getTime(3).toLocalTime();
                LocalTime endTime = rs.getTime(4).toLocalTime();
                int attendies = rs.getInt(5);
                int roomID = rs.getInt(6);
                String empID = rs.getString(7);
                Meeting meeting = new Meeting(mid, date, startTime, endTime, attendies, roomID, empID);
                mList.add(meeting);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return mList;
    }

    @Override
    public Meeting read(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

