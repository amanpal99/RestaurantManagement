/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apendix;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author amanpal
 */
public class ConnectionClass {
    static ConnectionClass connObj;
    public static Connection conn;
    private ConnectionClass()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
        }
        catch(Exception e)
        {
            System.out.println("SQL setting connection Error : "+e);
        }
        
    }
    public static ConnectionClass getConnObj()
    {
        if(connObj == null)
        {
            synchronized(ConnectionClass.class)
            {
                 if(connObj == null)
                 {
                     connObj = new ConnectionClass();
                 }
            }
        }
        
        return connObj;
    }
    
}