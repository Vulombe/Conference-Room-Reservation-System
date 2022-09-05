
package com.confrenseroom.service.impl;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.dboa.impl.MeetingDBOImpl;
import com.confrenseroom.model.Meeting;
import com.confrenseroom.service.CRUDService;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class MtServiceImpl implements CRUDService<Meeting>{
    private final MeetingDBOImpl  mtngCrud;

    public MtServiceImpl() {
        this.mtngCrud = new MeetingDBOImpl();
    }

    @Override
    public boolean create(Meeting mtng) {
        if(mtng.getEmpID()==null ||mtng.getEmpID().isEmpty())
            return false;
        if(mtng.getRoomID()<=0)
            return false;
        if(mtng.getDate()==null)
            return false;
        return mtngCrud.create(mtng);
    }

    @Override
    public Meeting readById(Meeting mtng) {
        if(mtng.getMeetID()<=0)
            return null;
        return mtngCrud.readById(mtng.getMeetID());
    }

    @Override
    public boolean update(Meeting mtng) {
        if(mtng.getMeetID()<=0)
            return false;
        return mtngCrud.update(mtng);
    }

    @Override
    public boolean delete(Meeting mtng) {
          if(mtng.getMeetID()<=0)
            return false;
        return mtngCrud.delete(mtng.getMeetID());
    }

    @Override
    public List<Meeting> getAll() {
        return mtngCrud.list();
    }

    @Override
    public LinkedList<Meeting> getlist() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
