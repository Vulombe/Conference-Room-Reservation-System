package com.confrenseroom.dboa.impl;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.model.Employee;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class EmployeeDBOImpl implements CRUD<Employee>{

    @Override
    public boolean create(Employee t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Employee read(String name) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean update(Employee t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Employee> list() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
