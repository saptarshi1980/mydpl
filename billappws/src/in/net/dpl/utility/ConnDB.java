package in.net.dpl.utility;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;



/**
 *
 * @author Accounts
 */
public class ConnDB {
 
    
public Connection make_connection(){ 
   
  
   Connection con=null;
   String c="jdbc:mysql://192.168.30.7/android";
   
   try{

       Class.forName("com.mysql.jdbc.Driver").newInstance();
       con = DriverManager.getConnection(c, "remote", "dgppro1961");
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





