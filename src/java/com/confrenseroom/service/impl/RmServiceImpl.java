/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.confrenseroom.service.impl;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.dboa.impl.RoomDBOImpl;
import com.confrenseroom.model.Room;
import com.confrenseroom.service.CRUDService;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class RmServiceImpl implements CRUDService<Room> {

    private final CRUD<Room> roomCrud;

    public RmServiceImpl() {
        this.roomCrud = new RoomDBOImpl();
    }

    @Override
    public boolean create(Room rm) {
        if (rm.getRoomName() == null || rm.getRoomName().isEmpty()) {
            return false;
        }
        return roomCrud.create(rm);
    }

    @Override
    public Room readById(Room rm) {
        if (rm.getRoomName() == null || rm.getRoomName().isEmpty()) {
            return null;
        }
        return roomCrud.read(rm.getRoomName());
    }

    @Override
    public boolean update(Room rm) {
        if (rm.getRoomName() == null || rm.getRoomName().isEmpty()) {
            return false;
        }
        return roomCrud.update(rm);
    }

    @Override
    public boolean delete(Room rm) {
        if (rm.getRoomName() == null || rm.getRoomName().isEmpty()) {
            return false;
        }
        return roomCrud.delete(rm.getRoomName());
    }

    @Override
    public List<Room> getAll() {
        return roomCrud.list();
    }

    @Override
    public LinkedList<Room> getlist() {
        return roomCrud.listLinked();
    }

}
