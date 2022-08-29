
package com.confrerenceroom.test.dbo;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.dboa.impl.EmployeeDBOImpl;
import com.confrenseroom.model.Employee;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestEmployee {
    public static void main(String[] args) {
               CRUD<Employee> empcrud = new EmployeeDBOImpl();
        //Test Create employee
//        String empID = RandomStringUtils.random(5, false, true);
//        Employee emp = new Employee(empID,"Dave Makhubele","Mr", "IT", "0761229739");
//        boolean created = empcrud.create(emp);
//        System.out.println("Create Status is "+created); 
        //Test Read Employee
//        Employee emp = empcrud.read("06436");
//        System.out.println("Employee Full Name: " +emp.getFullName()
//                                +"\nTitle: "+ emp.getTittle() +"\nDepartment: "+emp.getDepartment()
//                                +"\nCell Number: " +emp.getCellNumber());
        //Test Employee Update
//        Employee emp = empcrud.read("06436");
//        emp.setDepartment("ELECTRICITY");
//        boolean update = empcrud.update(emp);
//        System.out.println("Update Status is " +update);
        //Test Delete Employee
//        boolean delete = empcrud.delete("06436");
//        System.out.println("Delete Status is " +delete);
    }
}
