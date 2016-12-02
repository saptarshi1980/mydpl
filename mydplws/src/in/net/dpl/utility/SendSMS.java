package in.net.dpl.utility;

import java.sql.CallableStatement;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.PartialResultException;
import javax.net.ssl.HttpsURLConnection;

public class SendSMS {

	private final String USER_AGENT = "Mozilla/5.0";
        int batch_no=0;

	    String userName="durgapur";
		String password="Itcell@1357";
		String senderID="THEDPL";
                
		
		
		
	public void callSMSWs(String refNo){
		
try{
			
			
			String url = "http://192.168.30.9/WsSMS/smsws/send?refNo="+refNo;
			System.out.println(url);
			String newurl=url.replaceAll(" ","%20");
			URL obj = new URL(newurl);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
						}
					in.close();

					System.out.println(response.toString());
		
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}		
	}
		

	public void smsSend(String refNo)  {

		try{
			
			//String msg="Dear Consumer("+ conNo+"),"+"Bill for "+billPrd+ "=Rs "+amt + " each.Due dt-"+dueDate1+" and "+dueDate2+".Arrear Dues as on "+asOn+"-Rs "+arrear+ " plus Surcharge,ignore if paid";
			String billMonth=null;
			String amt=null;
			String mobNo=null;
			String conNo=null;
			String name=null;
			try{
				System.out.println("sms send function");
				Connection conn=new ConnDB().make_connection();
				ResultSet rs=conn.createStatement().executeQuery("SELECT transaction_amt,DATE_FORMAT(STR_TO_DATE(additionalinfo4_bill_month,'%y%m'),'%M-%y') AS bill_month,b.mob_no,a.consumer_no,b.name FROM v_response a,consdb.v_party_info b WHERE a.additionalinfo3_trans_ref_no='"+refNo.trim()+"' AND a.auth_status='0300' AND a.consumer_no=b.party_code AND TRIM(LENGTH(b.mob_no))>9");
				int counter=0;
				while(rs.next()){
					billMonth=rs.getString(2);
					amt=rs.getString(1);
					mobNo=rs.getString(3);
					conNo=rs.getString(4);
					name=rs.getString(5);
					counter++;					
				}
				if(counter==1){
					System.out.println(" SMS Send Module");
					String response1="Y";
					String msg="Dear Consumer ("+conNo+"), Online Payment for Bill Month "+billMonth+", amounting INR "+amt+" is Successful (Ref No-"+refNo+"), subject to realisation";
					String url = "http://www.smsjust.com/sms/user/urlsms.php?username="+userName+"&pass="+password+"&senderid="+senderID+"&dest_mobileno="+mobNo+"&message="+msg+"&response="+response1;
					String newurl=url.replaceAll(" ","%20");
					URL obj = new URL(newurl);
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("User-Agent", USER_AGENT);
					int responseCode = con.getResponseCode();
					System.out.println("\nSending 'GET' request to URL : " + url);
					System.out.println("Response Code : " + responseCode);

					BufferedReader in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
								response.append(inputLine);
								}
							in.close();
				String update="INSERT INTO sms_sent_billdesk (ref_no,msg,time_stamp) VALUES('"+refNo+"','"+msg+"','"+amt+"',NOW())";
				conn.createStatement().executeUpdate(update);
	
				}
	                 
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		

	}
	

	
}

