package in.net.dpl.core;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.sql.*;



/**
 *
 * @author Accounts
 */
public class ConnDB {
 
    
public Connection make_connection(){ 

String hostName=null;	
	
try {
	InetAddress IP=InetAddress.getLocalHost();
	
	hostName="192.168.30.2";
} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

   Connection con=null;
  
   String c="jdbc:mysql://"+hostName+"/consdb";
   
   try{

       Class.forName("com.mysql.jdbc.Driver").newInstance();
       con = DriverManager.getConnection(c, "remote", "dpl123");
       
       return con;    
      }catch (SQLException ex) {
       // TODO: handle exception
             ex.printStackTrace();
	} catch (Exception ex) {
	       // TODO: handle exception
        ex.printStackTrace();
} 
	
	return con;
     
    
}
}





