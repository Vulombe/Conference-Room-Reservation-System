package com.confrenseroom.service.impl;

import com.confrenseroom.dboa.impl.EmployeeDBOImpl;
import com.confrenseroom.model.Employee;
import com.confrenseroom.service.CRUDService;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class EmServiceImpl implements CRUDService<Employee> {

    private final EmployeeDBOImpl empCrud;

    public EmServiceImpl() {
        empCrud = new EmployeeDBOImpl();
    }

    boolean checkFields(String empID, String fullName, String tittle, String department, String cellNumber) {
        boolean available = true;
        if (empID == null || empID.isEmpty()) {
            return false;
        }
        if (fullName == null || fullName.isEmpty()) {
            return false;
        }
        if (tittle == null || tittle.isEmpty()) {
            return false;
        }
        if (department == null || department.isEmpty()) {
            return false;
        }
        return available;
    }

    @Override
    public boolean create(Employee emp) {
        boolean create = false;
        String id = emp.getEmpID();
        String name = emp.getFullName();
        String title = emp.getTittle();
        String department = emp.getDepartment();
        String cellnum = emp.getCellNumber();
        boolean available = checkFields(id, name, title, department, cellnum);
        if (available) {
            create = empCrud.create(emp);
        }
        return create;
    }

    @Override
    public Employee readById(Employee emp) {
        if (emp.getEmpID() == null || emp.getEmpID().isEmpty()) {
            return null;
        }
        return empCrud.read(emp.getEmpID());
    }

    @Override
    public boolean update(Employee emp) {
        boolean update = false;
        String id = emp.getEmpID();
        String name = emp.getFullName();
        String title = emp.getTittle();
        String department = emp.getDepartment();
        String cellnum = emp.getCellNumber();
        boolean available = checkFields(id, name, title, department, cellnum);
        if (available) {
            update = empCrud.update(emp);
        }
        return update;
    }

    @Override
    public boolean delete(Employee emp) {
        if (emp.getEmpID() == null || emp.getEmpID().isEmpty()) {
            return false;
        }
        return empCrud.delete(emp.getEmpID());
    }

    @Override
    public List<Employee> getAll() {
        return empCrud.list();
    }

}
