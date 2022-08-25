package com.confrenseroom.dboa.impl;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Meeting;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class MeetingDBOImpl implements CRUD<Meeting>{

    @Override
    public boolean create(Meeting t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Meeting read(String name) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean update(Meeting t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Meeting> list() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   
    
}
