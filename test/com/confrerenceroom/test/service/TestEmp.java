package com.confrerenceroom.test.service;

import com.confrenseroom.model.Employee;
import com.confrenseroom.service.CRUDService;
import com.confrenseroom.service.impl.EmServiceImpl;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestEmp {

    public static void main(String[] args) {
        CRUDService<Employee> empservice = new EmServiceImpl();
        //        Test Create employee
//        String empID = RandomStringUtils.random(5, false, true);
//        Employee emp = new Employee(empID,"Themba Valoyi","Mr", "MEDIA", "0875643354");
//        boolean create = empservice.create(emp);
//        System.out.println("Service create status is " +create);
//        Test Read Employee
//         Employee empcreate= (Employee) empservice.readById(new Employee("37263"));
//        System.out.println("Employee Full Name: " +empcreate.getFullName()
//                                +"\nTitle: "+ empcreate.getTittle() +"\nDepartment: "+empcreate.getDepartment()
//                                +"\nCell Number: " +empcreate.getCellNumber());
//        Test Employee Update
//        Employee empupdate= (Employee) empservice.readById(new Employee("15768"));
//        empupdate.setDepartment("ELECTRICITY");
//        boolean update = empservice.update(empupdate);
//        System.out.println("Update Status is " +update);
//        Test Delete Employee
//        Employee empupdate= new Employee("15768");
//        boolean delete = empservice.delete(empupdate);
//        System.out.println("Delete Status is " + delete);
    }
}
