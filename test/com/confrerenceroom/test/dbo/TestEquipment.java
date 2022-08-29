
package com.confrerenceroom.test.dbo;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.dboa.impl.EquipmentDBOImpl;
import com.confrenseroom.model.Equipment;
import com.confrenseroom.model.Status;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestEquipment {
    public static void main(String[] args) {
         CRUD<Equipment> eq = new EquipmentDBOImpl();
         //Test Create Equipment 
//         Equipment eq = new Equipment("Conventional overhead projectors",Status.AVAILABLE);
//         boolean create = eq.create(eq);
//         System.out.println("Create Status is " + create);
        //Test Read Equipment
        Equipment e = eq.readById(702);
//        System.out.println("Equipment name: "+e.getEquipmntName()
//                    + "\nStatus: " +e.getStatus());
        //Test Update Equipment
//        e.setStatus(Status.AVAILABLE);
//        boolean update = eq.update(e);
//        System.out.println("Update Status: "+update);
        //Test Delete Equipment
        boolean delete = eq.delete("Conventional overhead projectors");
        System.out.println("Delete Status is " + delete);
    }
}
