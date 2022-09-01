package com.confrerenceroom.test.service;

import com.confrenseroom.model.Room;
import com.confrenseroom.model.Status;
import com.confrenseroom.service.CRUDService;
import com.confrenseroom.service.impl.RmServiceImpl;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestRm {
    public static void main(String[] args) {
        CRUDService<Room> roomservice = new RmServiceImpl();
//             String roomName = "EastWest";
//     int capacity = 80;
//     Status status =Status.AVAILABLE;
//    
//     Room room = new Room(roomName,capacity,104,status);
//     boolean addRoom = roomservice.create(room);
//        System.out.println("Add Room Status is " + addRoom);/
//        Room room  = roomservice.readById(new Room("WEST021A"));
//        System.out.println("Name: " + room.getRoomName() + "\nCapacity: "
//                + room.getCapacity() + "\nRoom Status: " + room.getStatus());
//        Test Update Room
//        Room roomUp  = roomservice.readById(new Room("WEST021A"));
//        roomUp.setStatus(Status.NOTAVAILABLE);
//        boolean updated = roomservice.update(roomUp);
//        System.out.println("Update status is " + updated);
//        Test Delete Room
//        boolean delete = roomservice.delete(new Room("WEST021A"));
//        System.out.println("Delete Status is " +delete);
    }
}
