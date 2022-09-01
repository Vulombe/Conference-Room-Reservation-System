/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.confrerenceroom.test.service;

import com.confrenseroom.model.Equipment;
import com.confrenseroom.model.Status;
import com.confrenseroom.service.CRUDService;
import com.confrenseroom.service.impl.EqServiceImpl;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestEqp {
    public static void main(String[] args) {
        CRUDService<Equipment> eqpservice = new EqServiceImpl();
        Equipment e = eqpservice.readById(new Equipment(701));
//                 Test Create Equipment 
//         Equipment eq = new Equipment("Mic and Speakers",Status.AVAILABLE);
//         boolean create = eqpservice.create(eq);
//         System.out.println("Create Status is " + create);
//        Test Read Equipment
//        Equipment e = eqpservice.readById(new Equipment(704));
//        System.out.println("Equipment name: "+e.getEquipmntName()
//                    + "\nStatus: " +e.getStatus());
//        Test Update Equipment
//        e.setStatus(Status.AVAILABLE);
//        boolean update = eqpservice.update(e);
//        System.out.println("Update Status: "+update);
//        Test Delete Equipment
//        boolean delete = eqpservice.delete(e);
//        System.out.println("Delete Status is " + delete);
    }
}
