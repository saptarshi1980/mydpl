
import java.sql.*;

public class UpdateDB {

public static void main(String args[]){

	
	Connection conn=new ConnDB().make_connection();
	try{
		
		ResultSet rs=conn.createStatement().executeQuery("SELECT party_code,ADDRESS4,mob_no FROM m_party WHERE ADDRESS4>1 AND LENGTH(TRIM(address4))=10 AND LENGTH(TRIM(mob_no))=0");
		int i=0;
		while(rs.next()){
			
			
			conn.createStatement().executeUpdate("update m_party set mob_no='"+rs.getString("ADDRESS4")+"' where party_code='"+rs.getString("party_code")+"'");
			i++;
		}
		System.out.println("Total=="+i+"== Numbers of rows updated");
		
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	
	
}


}
