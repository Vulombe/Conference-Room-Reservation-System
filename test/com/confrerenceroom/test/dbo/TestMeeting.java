package com.confrerenceroom.test.dbo;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.dboa.impl.EmployeeDBOImpl;
import com.confrenseroom.dboa.impl.MeetingDBOImpl;
import com.confrenseroom.dboa.impl.RoomDBOImpl;
import com.confrenseroom.model.Employee;
import com.confrenseroom.model.Meeting;
import com.confrenseroom.model.Room;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestMeeting {
    public static void main(String[] args) {
        CRUD<Employee>  eCrud = new EmployeeDBOImpl();
        CRUD<Room>  rCrud = new RoomDBOImpl();
        CRUD<Meeting> mCrud = new MeetingDBOImpl();
//        Employee employee = eCrud.read("25005");
//        Room room = rCrud.read("EAST023B");
//        LocalDate date = LocalDate.now();
//        LocalTime st = LocalTime.now();
//        LocalTime et = st.plusHours(2);
//        Meeting meeting = new Meeting(date,st,et,50,room.getRoomID(),employee.getEmpID());
//        boolean create = mCrud.create(meeting);
//        System.out.println("Create Status is " + create);
        //Read Meeting
//        Meeting  read = mCrud.readById(5);
//        read.setAttendies(40);
//        Room room = rCrud.read("EAST022B");
//        Employee employee = eCrud.read(read.getEmpID());
//        System.out.println("Meeting Date: " +read.getDate().toString()
//                                + "\nStart Time: " +read.getStartTime().toString()
//                                +"\nEnd Time: " + read.getEndTime().toString()
//                                +"\nNumber of Attendies: " +read.getAttendies()
//                                +"\nMeeting Holder: " + employee.getFullName()
//                                +"\nMeeting Held at Room: " + room.getRoomName());
        //Update Meeting
//        Meeting  read = mCrud.readById(1);
//        read.setAttendies(20);
//        boolean update  = mCrud.update(read);
//        System.out.println("Update Status is: " +update);
        //Delete Meeting
        MeetingDBOImpl delt = new MeetingDBOImpl();
        boolean delete = delt.delete(5);
        System.out.println("Delete Status is " + delete);
    }
}
