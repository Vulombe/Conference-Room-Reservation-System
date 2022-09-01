/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.confrerenceroom.test.service;

import com.confrenseroom.model.Building;
import com.confrenseroom.service.CRUDService;
import com.confrenseroom.service.impl.BldServiceImpl;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestBld {
    public static void main(String[] args) {
        CRUDService<Building> bldservice = new BldServiceImpl();
        Building bld = bldservice.readById(new Building("NorthWestSouth"));
    //        Test Create Building
//        boolean bCreate = bldservice.create(new Building("NorthWestSouth"));
//        System.out.println("Create Statas is " + bCreate);
//        Test Read Building
//       Building bld = bldservice.readById(new Building("NorthWestSouth"));
//        System.out.println("Building name: " +bld.getBuildingName() +"\nBuilding ID: " + bld.getId() );
//        Test Update Building
//        bld.setId(432);
//        boolean update = bldservice.update(bld);
//        System.out.println("Update Statas is " + update);
//        Test Delete Building
//        boolean deleted = bldservice.delete(bld);
//        System.out.println("Delete Status " +deleted);
    }
    
}
