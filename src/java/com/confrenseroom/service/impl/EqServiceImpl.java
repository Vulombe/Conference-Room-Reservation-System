/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.confrenseroom.service.impl;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.dboa.impl.EquipmentDBOImpl;
import com.confrenseroom.model.Equipment;
import com.confrenseroom.service.CRUDService;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class EqServiceImpl implements CRUDService<Equipment> {

    private final CRUD<Equipment> eqpmntCrud;

    public EqServiceImpl() {
        this.eqpmntCrud = new EquipmentDBOImpl();
    }

    @Override
    public boolean create(Equipment eqp) {
        if (eqp.getEquipmntName() == null || eqp.getEquipmntName().isEmpty()) {
            return false;
        }
        return eqpmntCrud.create(eqp);
    }

    @Override
    public Equipment readById(Equipment eqp) {
        return eqpmntCrud.readById(eqp.getEquipmentID());
    }

    @Override
    public boolean update(Equipment eqp) {
        if (eqp.getEquipmntName() == null || eqp.getEquipmntName().isEmpty()) {
            return false;
        }
        return eqpmntCrud.update(eqp);
    }

    @Override
    public boolean delete(Equipment eqp) {
           if (eqp.getEquipmntName() == null || eqp.getEquipmntName().isEmpty()) {
            return false;
        }
        return eqpmntCrud.delete(eqp.getEquipmntName());
    }

    @Override
    public List<Equipment> getAll() {
        return eqpmntCrud.list();
    }

    @Override
    public LinkedList<Equipment> getlist() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
