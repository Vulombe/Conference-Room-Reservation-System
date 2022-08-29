package com.confrenseroom.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class Meeting {
     private int meetID;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int attendies;
    private int roomID;
    private String empID;

    public Meeting(LocalDate date, LocalTime startTime, LocalTime endTime, int attendies, int roomID, String empID) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.attendies = attendies;
        this.roomID = roomID;
        this.empID = empID;
    }

    public Meeting(int meetID, LocalDate date, LocalTime startTime, LocalTime endTime, int attendies, int roomID, String empID) {
        this.meetID = meetID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.attendies = attendies;
        this.roomID = roomID;
        this.empID = empID;
    }

    public int getMeetID() {
        return meetID;
    }

    public void setMeetID(int meetID) {
        this.meetID = meetID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getAttendies() {
        return attendies;
    }

    public void setAttendies(int attendies) {
        this.attendies = attendies;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    @Override
    public String toString() {
        return "Meeting{" + "meetID=" + meetID + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + ", attendies=" + attendies + ", roomID=" + roomID + ", empID=" + empID + '}';
    }

}
