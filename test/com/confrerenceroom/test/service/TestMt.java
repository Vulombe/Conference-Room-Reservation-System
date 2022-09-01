/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.confrerenceroom.test.service;

import com.confrenseroom.model.Employee;
import com.confrenseroom.model.Meeting;
import com.confrenseroom.model.Room;
import com.confrenseroom.service.CRUDService;
import com.confrenseroom.service.impl.MtServiceImpl;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestMt {

    public static void main(String[] args) {
        CRUDService<Meeting> mtngservice = new MtServiceImpl();
        //Test Create
//        CRUDService<Meeting> mtngservice = new MtServiceImpl();
//        LocalDate date = LocalDate.now();
//        LocalTime st = LocalTime.now();
//        LocalTime et = st.plusHours(2);
//        Meeting meeting = new Meeting(date, st, et, 90, 504, "37263");
//        boolean create = mtngservice.create(meeting);
//        System.out.println("Create Status is " + create);
//        Read Meeting
//         Meeting read = mtngservice.readById(new Meeting(7));
//        System.out.println("Meeting Date: " + read.getDate().toString()
//                + "\nStart Time: " + read.getStartTime().toString()
//                + "\nEnd Time: " + read.getEndTime().toString()
//                + "\nNumber of Attendies: " + read.getAttendies()
//                + "\nMeeting Holder: " + read.getEmpID()
//                + "\nMeeting Held at Room: " + read.getRoomID());
//        Update Meeting
//        Meeting  read = mtngservice.readById(new Meeting(7));
//        read.setAttendies(60);
//        boolean update  = mtngservice.update(read);
//        System.out.println("Update Status is: " +update);
//        Delete Meeting
//        boolean delete = mtngservice.delete(new Meeting(7));
//        System.out.println("Delete Status is " + delete);
    }
}
