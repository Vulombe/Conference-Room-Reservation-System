package com.confrenseroom.dboa.impl;

import com.confrenseroom.dbconncetion.DBConnector;
import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Meeting;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
            String statement = "insert into MEETING(meetingdate,endtime,starttime,attendies,roomID,empID)VALUES(?,?,?,?,?,?)";
            ps = DBConnector.getpStament(statement);

            Date date = Date.valueOf(t.getDate());
            Time sT = Time.valueOf(t.getStartTime());
            Time eT = Time.valueOf(t.getEndTime());
            ps.setDate(1, date);
            ps.setTime(2, eT);
            ps.setTime(3, sT);
            ps.setInt(4, t.getAttendies());
            ps.setInt(5, t.getRoomID());
            ps.setString(6, t.getEmpID());
            created = ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
        } finally {
            DBConnector.closeStreams(ps, rs);
        }
        return created;
    }

    @Override
    public Meeting read(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Meeting t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Meeting> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Meeting readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
//   {
//        }catch(SQLException | ClassNotFoundException ex)
//        {
//        }finally{
//            DBConnector.closeStreams(ps, rs);
//        }
