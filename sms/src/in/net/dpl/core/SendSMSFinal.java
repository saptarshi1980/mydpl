package in.net.dpl.core;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.PartialResultException;
import javax.net.ssl.HttpsURLConnection;

public class SendSMSFinal {

	private final String USER_AGENT = "Mozilla/5.0";

	public void sendSMS() throws Exception {

		String userName="durgapur";
		String password="Itcell@1357";
		String senderID="THEDPL";
		try{
			Connection conn=new ConnDB().make_connection();	
			//String selectQuery1="SELECT a.party_code AS party_code,a.bill_prd_from AS bill_prd_from,a.bill_prd_to AS bill_prd_to,a.amount AS amount,a.due_date1 AS due_date1,a.due_date2 AS due_date2, a.arrear AS arrear,a.as_on AS as_on,b.mob_no AS mobile FROM sms_master a,mobile b WHERE a.party_code=b.party_code  AND a.arrear !=0 and a.party_code NOT IN (SELECT  c.party_code  FROM sms_sent c,sms_master a WHERE c.party_code=a.party_code and  c.bill_prd_from=a.bill_prd_from AND c.bill_prd_to=a.bill_prd_to AND c.sent_status=200)";
			String selectQuery1="SELECT a.party_code AS party_code,a.bill_prd AS bill_prd,a.amount AS amount,a.due_date1 AS due_date1,a.due_date2 AS due_date2, a.arrear AS arrear,a.as_on AS as_on,b.mob_no AS mobile FROM u_bill a,m_party b WHERE a.party_code=b.party_code  AND a.arrear !=0 and length(b.mobile)=10 and a.party_code NOT IN (SELECT  c.party_code  FROM sms_sent c,u_bill a WHERE c.party_code=a.party_code and  c.bill_prd_from=a.bill_prd_from AND c.bill_prd_to=a.bill_prd_to AND c.sent_status=200)";
			//String selectQuery2="SELECT a.party_code AS party_code,a.bill_prd_from AS bill_prd_from,a.bill_prd_to AS bill_prd_to,a.amount AS amount,a.due_date1 AS due_date1,a.due_date2 AS due_date2, a.arrear AS arrear,a.as_on AS as_on,b.mob_no AS mobile FROM sms_master a,mobile b WHERE a.party_code=b.party_code  AND a.arrear =0 and a.party_code NOT IN (SELECT  c.party_code  FROM sms_sent c,sms_master a WHERE c.party_code=a.party_code and c.bill_prd_from=a.bill_prd_from AND c.bill_prd_to=a.bill_prd_to AND c.sent_status=200)";
			String selectQuery2="SELECT a.party_code AS party_code,a.bill_prd AS bill_prd,a.amount AS amount,a.due_date1 AS due_date1,a.due_date2 AS due_date2, a.arrear AS arrear,a.as_on AS as_on,b.mob_no AS mobile FROM u_bill a,m_party b WHERE a.party_code=b.party_code  AND a.arrear =0 and length(b.mobile)=10 and a.party_code NOT IN (SELECT  c.party_code  FROM sms_sent c,u_bill a WHERE c.party_code=a.party_code and c.bill_prd_from=a.bill_prd_from AND c.bill_prd_to=a.bill_prd_to AND c.sent_status=200)";
			Statement stmt1=conn.createStatement();
			Statement stmt2=conn.createStatement();
			ResultSet rs1=stmt1.executeQuery(selectQuery1);
			
			String partyCode,billPrd,amount,dueDate1,dueDate2,arrear,asOn,mobile;
			while(rs1.next()){
				
				partyCode=rs1.getString("party_code");
				//billPrdFrom=rs1.getString("bill_prd_from");
				//billPrdTo=rs1.getString("bill_prd_to");
				billPrd=rs1.getString("bill_prd");
				amount=rs1.getString("amount");
				dueDate1=rs1.getString("due_date1");
				dueDate2=rs1.getString("due_date2");
				arrear=rs1.getString("arrear");
				asOn=rs1.getString("as_on");
				mobile=rs1.getString("mobile");
				//sendGetwithArrear(userName,password,senderID,mobile,partyCode,billPrdFrom,billPrdTo,dueDate1,dueDate1,amount,arrear,asOn);
				sendGetwithArrear(userName,password,senderID,mobile,partyCode,billPrd,dueDate1,dueDate2,amount,arrear,asOn);
			}
			
			ResultSet rs2=stmt2.executeQuery(selectQuery2);
			while(rs2.next()){
				
				partyCode=rs2.getString("party_code");
				//billPrdFrom=rs2.getString("bill_prd_from");
				//billPrdTo=rs2.getString("bill_prd_to");
				billPrd=rs1.getString("bill_prd");
				amount=rs2.getString("amount");
				dueDate1=rs2.getString("due_date1");
				dueDate2=rs2.getString("due_date2");
				mobile=rs2.getString("mobile");
				//sendGetwithoutArrear(userName,password,senderID,mobile,partyCode,billPrdFrom,billPrdTo,dueDate1,dueDate1,amount);
				sendGetwithoutArrear(userName,password,senderID,mobile,partyCode,billPrd,dueDate1,dueDate2,amount);
			}
			
			
		}catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		
		
	}

	private void sendGetwithArrear(String userName,String password,String senderID,String recipient, String conNo,String billPrd,String dueDate1,String dueDate2,String amt,String arrear,String asOn)  {

		try{
			
			String msg="Dear Consumer("+ conNo+"), "+"Bill for "+billPrd+ " = Rs "+amt + " each. Due dt-"+dueDate1+" and "+dueDate2+" .Arrear Dues as on "+asOn+"-Rs "+arrear+ " plus Surcharge";
			System.out.println("Msg Lentgh-"+msg.length());
			String response1="Y";
			String url = "http://www.smsjust.com/sms/user/urlsms.php?username="+userName+"&pass="+password+"&senderid="+senderID+"&dest_mobileno="+recipient+"&message="+msg+"&response="+response1;
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
		
					String update="INSERT INTO sms_sent (party_code,bill_prd,amount,due_date1,due_date2,arrear,as_on,mobile,sent_status,msg) VALUES('"+conNo+"','"+billPrd+"','"+amt+"','"+dueDate1+"','"+dueDate2+"','"+arrear+"','"+asOn+"','"+recipient+"','"+String.valueOf(responseCode)+"','"+msg+"')";
		
		try{
			Connection conn=new ConnDB().make_connection();
			conn.createStatement().executeUpdate(update);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		}catch(IOException ex){
			ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
private void sendGetwithoutArrear(String userName,String password,String senderID,String recipient, String conNo,String billPrd,String dueDate1,String dueDate2,String amt) throws Exception {

		String msg="Dear Consumer("+ conNo+"), "+"Bill for "+billPrd+ " = Rs "+amt + "each. Due Dt-"+dueDate1+" and "+dueDate2+".";
		String response1="Y";
		String url = "http://www.smsjust.com/sms/user/urlsms.php?username="+userName+"&pass="+password+"&senderid="+senderID+"&dest_mobileno="+recipient+"&message="+msg+"&response="+response1;
		System.out.println(url);
		String newurl=url.replaceAll(" ","%20");
		URL obj = new URL(newurl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
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
		
		String update="INSERT INTO sms_sent (party_code,bill_prd,amount,due_date1,due_date2,mobile,sent_status,msg) VALUES('"+conNo+"','"+billPrd+"','"+amt+"','"+dueDate1+"','"+dueDate2+"','"+recipient+"','"+String.valueOf(responseCode)+"','"+msg+"')";

		try{
			Connection conn=new ConnDB().make_connection();
			conn.createStatement().executeUpdate(update);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		

	}

	
	
}