/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.confrenseroom.service.impl;

import com.confrenseroom.dboa.impl.BuildingDBOImpl;
import com.confrenseroom.model.Building;
import com.confrenseroom.service.CRUDService;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class BldServiceImpl implements CRUDService<Building> {

    private final BuildingDBOImpl bldCrud;

    public BldServiceImpl() {
        bldCrud = new BuildingDBOImpl();
    }

    @Override
    public boolean create(Building bld) {
        if (bld.getBuildingName() == null || bld.getBuildingName().isEmpty()) {
            return false;
        }
        return bldCrud.create(bld);
    }

    @Override
    public Building readById(Building bld) {
        if (bld.getBuildingName() == null || bld.getBuildingName().isEmpty()) {
            return null;
        }
        return bldCrud.read(bld.getBuildingName());
    }

    @Override
    public boolean update(Building bld) {
        if (bld.getBuildingName() == null || bld.getBuildingName().isEmpty()) {
            return false;
        }
        return bldCrud.update(bld);
    }

    @Override
    public boolean delete(Building bld) {
        if (bld.getBuildingName() == null || bld.getBuildingName().isEmpty()) {
            return false;
        }
        return bldCrud.delete(bld.getBuildingName());
    }

    @Override
    public List<Building> getAll() {
        return bldCrud.list();
     }
}
