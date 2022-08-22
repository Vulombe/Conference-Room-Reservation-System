
package com.confrerenceroom.test.dbo;

import com.confrenseroom.dboa.CRUD;
import com.confrenseroom.dboa.impl.UserDBOImpl;
import com.confrenseroom.model.User;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class TestUser {
    public static void main(String[] args) {
        CRUD<User> usercrud = new UserDBOImpl();
        //create user
        String code = RandomStringUtils.random(5, false, true);
        User user = new User(code,"Samuel" , "Gezman", "HEALTH", "076543252", "gezman@gmail.com", "7667");
        boolean created = usercrud.create(user);
        System.out.println(created);
        //Read User
//        User readUser = usercrud.read("deedaniles@gmail.com");
//        System.out.println("First Name: " +readUser.getFirstname()+ "\nLast Name: " +readUser.getLastname());
    }
}
