package com.confrenseroom.dbconncetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

    public final static PreparedStatement getpStament(String pStament) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String theURL = "jdbc:mysql://localhost:3306/confrenceroomdb ?useSSL=false";
        String userID = "root";
        String passwd = "mecer";
        Connection myCon = DriverManager.getConnection(theURL, userID, passwd);
        ps = myCon.prepareStatement(pStament);
        return ps;
    }
    public static void closeStreams(PreparedStatement ps,ResultSet rs)
    {
        try{
            if(ps !=null)
                ps.close();
            if(rs !=null)
                rs.close();
            }catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
    }
    
}
