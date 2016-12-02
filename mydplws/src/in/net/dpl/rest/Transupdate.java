package in.net.dpl.rest;
 

import in.net.dpl.utility.ConnDB;
import in.net.dpl.utility.SendSMS;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;

/**
 * @author Crunchify.com
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import in.net.dpl.dao.Project;
import in.net.dpl.dto.BillHistory;
import in.net.dpl.dto.Consumer;
import in.net.dpl.dto.FeedObjects;
import in.net.dpl.dto.Tariff;
import in.net.dpl.utility.ExamineMessage;
 
@Path("/transupdate")
public class Transupdate {
	
	
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
	
	@POST
	@Path("/post")
	@Produces(MediaType.TEXT_PLAIN)
	public String directUpdate(@Context HttpServletRequest request,@FormParam("msg") String msg) {
		
		System.out.println("MSG-"+msg);
		String ipRemote = request.getRemoteAddr().trim();
		System.out.println("remote ip:"+ipRemote);
		//if(ipRemote.matches("210.210.24.74")){
		System.out.println("inside direct");
		//StringBuffer sbmsg=new StringBuffer(msg);
		String checksumBD=msg.substring(msg.lastIndexOf("|")+1, msg.length());
		String originalMsg=msg.substring(0,msg.lastIndexOf("|"));
		//String checkSumDPL=HmacSHA256(originalMsg, ChecksumKey);
		String checkSumDPL=new ChecksumBillDesk().HmacSHA256(originalMsg, ChecksumKey);
		System.out.println("Direct CheckSum Bd-"+checksumBD);
		System.out.println("Direct CheckSum DPL-"+checkSumDPL);
		System.out.println("Direct Message part only-"+originalMsg);
		
		
		//System.out.println("CheckSum Bd-"+checksumBD);
		//System.out.println("CheckSum DPL-"+checkSumDPL);
		//System.out.println("Message part only-"+originalMsg);
		
		if(checksumBD.trim().equals(checkSumDPL.trim())){
			//System.out.println("Checksum Matched, Authorised Transaction. Transaction Reports will be updated");
			extractString(originalMsg);
			int pos=addInfo5.indexOf("-");
			String ip=addInfo5.substring(0,pos);
			double rebate=Double.valueOf(addInfo5.substring(pos+1).trim());
			//System.out.println("IP="+ip+", rebate="+rebate);
			
			
			Connection conn=new ConnDB().make_connection();
			try{
				conn.createStatement().executeUpdate("update transaction set final_status='COMPLETED',billdesk_status='"+authStatus+"' where transaction_ref_no='"+addInfo3+"' and transaction_amt='"+txnAmt+"' and original_status='PENDING'");
				conn.createStatement().executeUpdate("insert into direct_response (merchant_id,consumer_no,bd_trans_ref,bank_ref_no,transaction_amt,bank_id,bank_merchant_id,transaction_type,currency_name,item_code,security_type,security_id,security_password,transaction_date,auth_status,settlement_type,additionalinfo1_date,additionalinfo2_tran_type,additionalinfo3_trans_ref_no,additionalinfo4_bill_month,additionalinfo5_remarks,additionalinfo6,additionalinfo7,error_status,error_description,checksum,completion_ts,rebate) "
						+ "values('"+merchantID+"','"+customerID+"','"+txnRefNo+"','"+bankRefNo+"','"+txnAmt+"','"+bankID+"','"+bankMerchantID+"','"+txnType+"','"+currencyName+"','"+itemCode+"','"+securityType+"','"+securityID+"','"+securityPassword+"',str_to_date('"+transactionDate+"','%d-%m-%Y %H:%i:%s'),'"+authStatus+"','"+settlementType+"','"+addInfo1+"','"+addInfo2+"','"+addInfo3+"','"+addInfo4+"','"+addInfo5+"','"+addInfo6+"','"+addInfo7+"','"+errorStatus+"','"+errorDescription+"','"+checksumBD+"',NOW(),"+rebate+")");
				
				
					
					new SendSMS().callSMSWs(addInfo3);
				
				
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
		else{
			System.out.println("Checksum Mis Match, Transaction Declined. ");
			//request.getRequestDispatcher("error.jsp").forward(request, response);
			return "999";
		}
		
		return "300";
		}
		
	
	
	
	
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
	    
	    
	     
	    
	    

	}

@GET
@Path("/get")
@Produces(MediaType.TEXT_PLAIN)
public String print() {

return "TEST";
}


}

