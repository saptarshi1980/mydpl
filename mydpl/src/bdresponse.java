

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BillInfo;
//import sun.security.krb5.internal.crypto.DesCbcCrcEType;

/**
 * Servlet implementation class bdresponse
 */
@WebServlet("/bdresponse")
public class bdresponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String merchantID=null;
    String customerID=null;
    String txnRefNo=null;
    String bankRefNo=null;
    String txnAmt=null;
    String bankID=null;
    String bankMerchantID=null;
    String txnType=null;
    String currencyName=null;
    String itemCode=null;
    String securityType=null;
    String securityID=null;
    String securityPassword=null;
    String transactionDate=null;
    String authStatus=null;
    String settlementType=null;
    String addInfo1=null;
    String addInfo2=null;
    String addInfo3=null;
    String addInfo4=null;
    String addInfo5=null;
    String addInfo6=null;
    String addInfo7=null;
    String errorStatus=null;
    String errorDescription=null;
    String rebate=null;
	
	String ChecksumKey ="a3VkNtgWZNwu";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bdresponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg=request.getParameter("msg");
		StringBuffer sbmsg=new StringBuffer(msg);
		String checksumBD=msg.substring(msg.lastIndexOf("|")+1, msg.length());
		String originalMsg=msg.substring(0,msg.lastIndexOf("|"));
		//String checkSumDPL=HmacSHA256(originalMsg, ChecksumKey);
		String checkSumDPL=new ChecksumBillDesk().HmacSHA256(originalMsg, ChecksumKey);
		
		System.out.println("CheckSum Bd-"+checksumBD);
		System.out.println("CheckSum DPL-"+checkSumDPL);
		System.out.println("Message part only-"+originalMsg);
		int transactionTime=0;
		
		if(checksumBD.matches(checkSumDPL)){
			//System.out.println("Checksum Matched, Authorised Transaction. Transaction Reports will be updated");
			extractString(originalMsg);
			transactionTime=getTransactionTime(addInfo3);
		    //updateAllRespose(checksumBD);
			if(transactionTime<31)
			{
						int pos=addInfo5.indexOf("-");
						String ip=addInfo5.substring(0,pos);
						double rebate=Double.valueOf(addInfo5.substring(pos+1).trim());
						//System.out.println("IP="+ip+", rebate="+rebate);
						
						
						Connection conn=new ConnDB().make_connection();
						try{
							conn.createStatement().executeUpdate("update transaction set final_status='COMPLETED',billdesk_status='"+authStatus+"' where transaction_ref_no='"+addInfo3+"' and transaction_amt='"+txnAmt+"' and original_status='PENDING'");
							conn.createStatement().executeUpdate("insert into general_response (merchant_id,consumer_no,bd_trans_ref,bank_ref_no,transaction_amt,bank_id,bank_merchant_id,transaction_type,currency_name,item_code,security_type,security_id,security_password,transaction_date,auth_status,settlement_type,additionalinfo1_date,additionalinfo2_tran_type,additionalinfo3_trans_ref_no,additionalinfo4_bill_month,additionalinfo5_remarks,additionalinfo6,additionalinfo7,error_status,error_description,checksum,completion_ts,rebate) "
									+ "values('"+merchantID+"','"+customerID+"','"+txnRefNo+"','"+bankRefNo+"','"+txnAmt+"','"+bankID+"','"+bankMerchantID+"','"+txnType+"','"+currencyName+"','"+itemCode+"','"+securityType+"','"+securityID+"','"+securityPassword+"',str_to_date('"+transactionDate+"','%d-%m-%Y %H:%i:%s'),'"+authStatus+"','"+settlementType+"','"+addInfo1+"','"+addInfo2+"','"+addInfo3+"','"+addInfo4+"','"+addInfo5+"','"+addInfo6+"','"+addInfo7+"','"+errorStatus+"','"+errorDescription+"','"+checksumBD+"',NOW(),"+rebate+")");
							//conn.createStatement().executeUpdate("delete from login where consumer_no='"+customerID+"'");
							request.setAttribute("ref_no", addInfo3);
							request.getRequestDispatcher("paymentStatus.jsp").forward(request, response);
							
						}catch(SQLException ex){
							ex.printStackTrace();
						}finally{
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
		
			}
			
							
			
			
			
							else
							{
								request.getRequestDispatcher("timeout.jsp").forward(request, response);
							}
		
		
		
		}
		
		
		
		
		
		else{
			System.out.println("Checksum Mis Match, Transaction Declined. ");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
		
	}
	
	
	/*public String extractString(String msg){
	    
	    int i=0;
	    String var0=null;
	    String var1=null;
	    String var2=null;
	    String var3=null;
	    String var4=null;
	    
	    String[] value_split = msg.split("\\|");
	    for (String string : value_split) {

	        
	        System.out.println(string);

	    }
	    for(i=0;i<value_split.length;i++){
	        
	        if(i==0){
	            var0=value_split[i];
	        }
	        else if(i==1){
	            var1=value_split[i];
	        }
	        else if(i==2){
	            var2=value_split[i];
	        }
	        
	        else if(i==3){
	            var3=value_split[i];
	        }
	        else if(i==4){
	            var4=value_split[i];
	        }
	        
	    }
	    
	    
	    System.out.println("VAR 0="+var0);
	    System.out.println("VAR 1="+var1);
	    System.out.println("VAR 2="+var2);
	    System.out.println("VAR 3="+var3);
	    System.out.println("VAR 4="+var4);

	}*/
	
	/*public String HmacSHA256(String message,String secret)  {
		MessageDigest md = null;
			try {

				Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
				 SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
				 sha256_HMAC.init(secret_key);
				byte raw[] = sha256_HMAC.doFinal(message.getBytes());
				StringBuffer ls_sb=new StringBuffer();
				for(int i=0;i<raw.length;i++)
					ls_sb.append(char2hex(raw[i]));
					return ls_sb.toString(); //step 6
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	public static String char2hex(byte x)
	{
	    char arr[]={
	                  '0','1','2','3',
	                  '4','5','6','7',
	                  '8','9','A','B',
	                  'C','D','E','F'
	                };

	    char c[] = {arr[(x & 0xF0)>>4],arr[x & 0x0F]};
	    return (new String(c));
	  }
	*/
	public void extractString(String msg){
	    
	    int i=0;
	    
	    
	    
	    
	    String[] value_split = msg.split("\\|");
	    for (String string : value_split) {

	        
	        System.out.println(string);

	    }
	    for(i=0;i<value_split.length;i++){
	        
	        if(i==0){
	            this.merchantID=value_split[i];
	        }
	        else if(i==1){
	        	 this.customerID=value_split[i];
	        }
	        else if(i==2){
	        	 this.txnRefNo=value_split[i];
	        }
	        
	        else if(i==3){
	        	 this.bankRefNo=value_split[i];
	        }
	        else if(i==4){
	        	 this.txnAmt=value_split[i];
	        }
	        else if(i==5){
	        	 this.bankID=value_split[i];
	        }
	        else if(i==6){
	            this.bankMerchantID=value_split[i];
	        }
	        else if(i==7){
	            this.txnType=value_split[i];
	        }
	        else if(i==8){
	            this.currencyName=value_split[i];
	        }
	        else if(i==9){
	            this.itemCode=value_split[i];
	        }
	        else if(i==10){
	            this.securityType=value_split[i];
	        }
	        else if(i==11){
	            this.securityID=value_split[i];
	        }
	        else if(i==12){
	            this.securityPassword=value_split[i];
	        }
	        else if(i==13){
	            this.transactionDate=value_split[i];
	        }
	        else if(i==14){
	            this.authStatus=value_split[i];
	        }
	        else if(i==15){
	            this.settlementType=value_split[i];
	        }
	        else if(i==16){
	            this.addInfo1=value_split[i];
	        }
	        else if(i==17){
	            this.addInfo2=value_split[i];
	        }
	        else if(i==18){
	            this.addInfo3=value_split[i];
	        }
	        else if(i==19){
	            this.addInfo4=value_split[i];
	        }
	        else if(i==20){
	            this.addInfo5=value_split[i];
	        }
	        else if(i==21){
	            this.addInfo6=value_split[i];
	        }
	        else if(i==22){
	            this.addInfo7=value_split[i];
	        }
	        else if(i==23){
	            this.errorStatus=value_split[i];
	        }
	        else if(i==24){
	            this.errorDescription=value_split[i];
	        }
	        
	    }
	    
	    
	    /*System.out.println("Merchant id "+merchantID);
	    System.out.println("Consumer id="+customerID);
	    System.out.println("TXN Ref No="+txnRefNo);
	    System.out.println("Bank Ref No="+bankRefNo);
	    System.out.println("TXN Amt="+txnAmt);
	    System.out.println("Bank ID="+bankID);
	    System.out.println("Ban Merchant ID="+bankMerchantID);
	    System.out.println("TXN Type="+txnType);
	    System.out.println("Currency Name="+currencyName);
	    System.out.println("Item code="+itemCode);
	    System.out.println("Security Type="+securityType);
	    System.out.println("Security ID="+securityID);
	    System.out.println("Security Password="+securityPassword);
	    System.out.println("Transaction date="+transactionDate);
	    System.out.println("Auth Status="+authStatus);
	    System.out.println("Settlement Type="+settlementType);
	    System.out.println("Add info 1 ="+addInfo1);
	    System.out.println("Add info 2 ="+addInfo2);
	    System.out.println("Add info 3 ="+addInfo3);
	    System.out.println("Add info 4 ="+addInfo4);
	    System.out.println("Add info 5 ="+addInfo5);
	    System.out.println("Add info 6 ="+addInfo6);
	    System.out.println("Add info 7 ="+addInfo7);
	    System.out.println("Error Status ="+errorStatus);
	    System.out.println("Description ="+errorDescription);*/
	    
	       
	}
	
	
	public int getTransactionTime(String transactionRefNo)
	{
		
		int transactionTimeInt=0;
		String transactionTime=null;
		Connection conn=new ConnDB().make_connection();
		try{
			ResultSet rs=conn.createStatement().executeQuery("SELECT TIMESTAMPDIFF(MINUTE,initiation_ts,NOW()) AS transaction_time FROM transaction where transaction_ref_no='"+transactionRefNo+"' ");
			while(rs.next()){
				transactionTime=rs.getString("transaction_time");
			}
			
			try{
				transactionTimeInt=Integer.parseInt(transactionTime);	
			}catch(NumberFormatException ex){
				
				ex.printStackTrace();
			}
			
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return transactionTimeInt;
		
		}
		
	}

	public void updateAllRespose(String checksumBD){
	
		
		Connection conn=new ConnDB().make_connection();
		try{
			
			conn.createStatement().executeUpdate("insert into all_response (merchant_id,consumer_no,bd_trans_ref,bank_ref_no,transaction_amt,bank_id,bank_merchant_id,transaction_type,currency_name,item_code,security_type,security_id,security_password,transaction_date,auth_status,settlement_type,additionalinfo1_date,additionalinfo2_tran_type,additionalinfo3_trans_ref_no,additionalinfo4_bill_month,additionalinfo5_remarks,additionalinfo6,additionalinfo7,error_status,error_description,checksum,completion_ts,rebate) "
					+ "values('"+merchantID+"','"+customerID+"','"+txnRefNo+"','"+bankRefNo+"','"+txnAmt+"','"+bankID+"','"+bankMerchantID+"','"+txnType+"','"+currencyName+"','"+itemCode+"','"+securityType+"','"+securityID+"','"+securityPassword+"',str_to_date('"+transactionDate+"','%d-%m-%Y %H:%i:%s'),'"+authStatus+"','"+settlementType+"','"+addInfo1+"','"+addInfo2+"','"+addInfo3+"','"+addInfo4+"','"+addInfo5+"','"+addInfo6+"','"+addInfo7+"','"+errorStatus+"','"+errorDescription+"','"+checksumBD+"',NOW(),"+rebate+")");
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
