package com.confrenseroom.dbconncetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnector {

    public static PreparedStatement getpStament(String pStament) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String theURL = "jdbc:mysql://localhost:3306/confrenceroomdb ?useSSL=false";
        String userID = "root";
        String passwd = "mecer";
        Connection myCon = DriverManager.getConnection(theURL, userID, passwd);
        ps = myCon.prepareStatement(pStament);
        return ps;
    }

}
