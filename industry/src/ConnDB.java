

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.sql.*;

import javax.servlet.RequestDispatcher;

/**
 *
 * @author Accounts
 */
public class ConnDB {
 
    
public Connection make_connection(){ 

String hostName=null;	
	
try {
	InetAddress IP=InetAddress.getLocalHost();
	//hostName=IP.getHostName();
	hostName="192.168.30.7";
} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

   Connection con=null;
   //String c="jdbc:mysql://localhost/dplsw";
   String c="jdbc:mysql://"+hostName+"/dplsw";
   
   try{

       Class.forName("com.mysql.jdbc.Driver").newInstance();
       con = DriverManager.getConnection(c, "remote", "dgppro1961");
       //con = DriverManager.getConnection(c, "root", "dpl123");
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





