
package com.confrerenceroom.test.dbo;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.dboa.impl.RoomDBOImpl;
import com.confrenseroom.model.Room;
import com.confrenseroom.model.Status;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestRoom {
    public static void main(String[] args) {
        CRUD<Room> roomcrudobj = new RoomDBOImpl();
//        
//          int roomID;
//     String roomName = "WEST021AB";
//     int capacity = 100;
//     Status status =Status.AVAILABLE;
//     int equipmentID = 0;
//     Room room = new Room(roomName,capacity,0,status);
//     boolean addRoom = roomcrudobj.create(room);
//        System.out.println("Add Room Status is " + addRoom);
        //Test Read Room

//        System.out.println("Name: " +room.getRoomName()+"\nCapacity: " + 
//                room.getCapacity()+"\nRoom Status: " +room.getStatus());
        //Test Update Room
//        Room roomUp  = roomcrudobj.read("WEST021A");
//        roomUp.setCapacity(30);
//        boolean updated = roomcrudobj.update(roomUp);
//        System.out.println("Update Status is " + updated);
        //Test Delete Room
//        boolean delete = roomcrudobj.delete("WEST021AB");
//        System.out.println("Delete Status is " +delete);
    }
}
