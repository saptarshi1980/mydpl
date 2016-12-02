package in.net.dpl;
import java.sql.*;

/**
 *
 * @author dpl 1
 */
public class AdjustBrokenTransaction {
    
	public boolean  adjust(){
        String query1="SELECT a.con_no,a.transaction_ref_no AS ref_no,a.transaction_date,a.settlement_date,a.bill_month AS bill_month,a.bd_ref_no,a.bank_ref_no,a.net_amount,a.bank_id,a.transaction_date,b.remarks,a.date_of_txn,b.billdesk_status,a.mis_date FROM billdesk_mis_settled a,transaction b WHERE a.transaction_ref_no=b.transaction_ref_no AND b.billdesk_status='0000' ORDER BY a.date_of_txn";
        Connection conn=new ConnDB().make_connection();
        
        try{
            ResultSet rs=conn.createStatement().executeQuery(query1);
            int counter=1;
            while(rs.next()){
                    System.out.println("Pass No-"+counter);
                    conn.createStatement().executeUpdate("delete from direct_response where additionalinfo3_trans_ref_no='"+rs.getString(2) +"'");
                    String remarks=rs.getString("remarks");
                    int pos=remarks.indexOf("-");
                    double rebate=Double.valueOf(remarks.substring(pos+1).trim());
                    conn.createStatement().executeUpdate("update transaction set final_status='COMPLETED',billdesk_status='0300' where transaction_ref_no='"+rs.getString(2) +"'");
                    conn.createStatement().executeUpdate("insert into direct_response (merchant_id,consumer_no,bd_trans_ref,bank_ref_no,transaction_amt,bank_id,bank_merchant_id,transaction_type,currency_name,item_code,security_type,security_id,security_password,transaction_date,auth_status,settlement_type,additionalinfo1_date,additionalinfo2_tran_type,additionalinfo3_trans_ref_no,additionalinfo4_bill_month,additionalinfo5_remarks,additionalinfo6,additionalinfo7,error_status,error_description,checksum,completion_ts,rebate) values('DURGAPUR','"+rs.getString(1)+"','"+rs.getString("bd_ref_no")+"','"+rs.getString("bank_ref_no")+"','"+rs.getDouble("net_amount")+"','"+rs.getString("bank_id")+"','NA','01','INR','DIRECT','NA','NA','NA','"+rs.getString("transaction_date")+"','0300','NA','"+rs.getString("transaction_date")+"','E','"+rs.getString(2)+"','"+rs.getString("bill_month")+"','"+rs.getString("remarks")+"','NA','NA','NA','Y','MIS UPLOAD','"+rs.getString("date_of_txn")+"','"+rebate+"')");
                    conn.createStatement().executeUpdate("insert into broken_log values('"+rs.getString(2)+"',NOW())");
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean adjustMisc(){
    	
    	String queryString="SELECT transaction_ref_no FROM transaction WHERE billdesk_status='0300' AND transaction_ref_no NOT IN(SELECT additionalinfo3_trans_ref_no FROM v_response)";
    	Connection conn=new ConnDB().make_connection();
    	try{
            ResultSet rs=conn.createStatement().executeQuery(queryString);
            while(rs.next()){
               
                ResultSet rs1=conn.createStatement().executeQuery("SELECT * FROM billdesk_mis_settled WHERE transaction_ref_no='"+rs.getString(1)+"'");
                while(rs1.next()){
                	 String remarks=rs1.getString("remarks").replace(",", " ");
                	 System.out.println("Remarks-"+remarks);
                     int pos=remarks.indexOf("-");
                     double rebate=Double.valueOf(remarks.substring(pos+1).trim());
                     System.out.println("Rebate-"+rebate);
                     
                     //conn.createStatement().executeUpdate("update transaction set final_status='COMPLETED',billdesk_status='0300' where transaction_ref_no='"+rs.getString(2) +"'");
                     conn.createStatement().executeUpdate("insert into direct_response (merchant_id,consumer_no,bd_trans_ref,bank_ref_no,transaction_amt,bank_id,bank_merchant_id,transaction_type,currency_name,item_code,security_type,security_id,security_password,transaction_date,auth_status,settlement_type,additionalinfo1_date,additionalinfo2_tran_type,additionalinfo3_trans_ref_no,additionalinfo4_bill_month,additionalinfo5_remarks,additionalinfo6,additionalinfo7,error_status,error_description,checksum,completion_ts,rebate) values('DURGAPUR','"+rs1.getString("con_no")+"','"+rs1.getString("bd_ref_no")+"','"+rs1.getString("bank_ref_no")+"','"+rs1.getDouble("net_amount")+"','"+rs1.getString("bank_id")+"','NA','01','INR','DIRECT','NA','NA','NA','"+rs1.getString("transaction_date")+"','0300','NA','"+rs1.getString("transaction_date")+"','E','"+rs1.getString("transaction_ref_no")+"','"+rs1.getString("bill_month")+"','"+rs1.getString("remarks")+"','NA','NA','NA','Y','MANUAL','"+rs1.getString("date_of_txn")+"','"+rebate+"')");
                     conn.createStatement().executeUpdate("insert into broken_log values('"+rs1.getString("transaction_ref_no")+"',NOW())");
                }
                
                
            }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    	
    	
    	
    }
    
    
    
public void  adjustSuccesasPerTransaction(){
        
        System.out.println("function");
        Connection conn=new ConnDB().make_connection();
        String queryrefNo="select transaction_ref_no from transaction where billdesk_status=0300 and transaction_ref_no not in(select additionalinfo3_trans_ref_no from v_response WHERE  auth_status=0300)";
        try{
        
            ResultSet rsRefNo=conn.createStatement().executeQuery(queryrefNo);
            while(rsRefNo.next()){
                
                System.out.println("INSIDE rsRefNo");
                String queryExtractInfo="SELECT * FROM billdesk_mis_settled WHERE transaction_ref_no='"+rsRefNo.getString(1)+"'";
                ResultSet rsDetail=conn.createStatement().executeQuery(queryExtractInfo);
                while(rsDetail.next()){
                    System.out.println("INSIDE rsDetails");
                    String remarks=rsDetail.getString("remarks");
                    int pos=remarks.indexOf("-");
                    double rebate=Double.valueOf(remarks.substring(pos+1).trim());
                    conn.createStatement().executeUpdate("delete from direct_response where additionalinfo3_trans_ref_no='"+rsDetail.getString("transaction_ref_no")+"'");
                    conn.createStatement().executeUpdate("delete from general_response where additionalinfo3_trans_ref_no='"+rsDetail.getString("transaction_ref_no")+"'");
                    conn.createStatement().executeUpdate("insert into direct_response (merchant_id,consumer_no,bd_trans_ref,bank_ref_no,transaction_amt,bank_id,bank_merchant_id,transaction_type,currency_name,item_code,security_type,security_id,security_password,transaction_date,auth_status,settlement_type,additionalinfo1_date,additionalinfo2_tran_type,additionalinfo3_trans_ref_no,additionalinfo4_bill_month,additionalinfo5_remarks,additionalinfo6,additionalinfo7,error_status,error_description,checksum,completion_ts,rebate) values('DURGAPUR','"+rsDetail.getString("con_no")+"','"+rsDetail.getString("bd_ref_no")+"','"+rsDetail.getString("bank_ref_no")+"','"+rsDetail.getDouble("net_amount")+"','"+rsDetail.getString("bank_id")+"','NA','01','INR','DIRECT','NA','NA','NA','"+rsDetail.getString("transaction_date")+"','0300','NA','"+rsDetail.getString("transaction_date")+"','E','"+rsDetail.getString("transaction_ref_no")+"','"+rsDetail.getString("bill_month")+"','"+rsDetail.getString("remarks")+"','NA','NA','NA','Y','MIS UPLOAD','"+rsDetail.getString("date_of_txn")+"','"+rebate+"')");
                    conn.createStatement().executeUpdate("insert into broken_log values('"+rsDetail.getString("transaction_ref_no")+"',NOW())");
                                          
                }
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        
    }
    
    
    
    public boolean  adjustAsPerBilldeskSettled(){
        String query1="SELECT con_no,transaction_ref_no AS ref_no,transaction_date,settlement_date,bill_month AS bill_month,bd_ref_no,bank_ref_no,net_amount,bank_id,transaction_date,remarks,date_of_txn,mis_date FROM billdesk_mis_settled WHERE transaction_ref_no IN(SELECT transaction_ref_no FROM transaction WHERE  billdesk_status!=0300)";
        Connection conn=new ConnDB().make_connection();
        
        try{
            ResultSet rs=conn.createStatement().executeQuery(query1);
            int counter=1;
            while(rs.next()){
                    System.out.println("Pass No-"+counter);
                    conn.createStatement().executeUpdate("delete from direct_response where additionalinfo3_trans_ref_no='"+rs.getString(2) +"'");
                    String remarks=rs.getString("remarks");
                    int pos=remarks.indexOf("-");
                    double rebate=Double.valueOf(remarks.substring(pos+1).trim());
                    conn.createStatement().executeUpdate("update transaction set final_status='COMPLETED',billdesk_status='0300' where transaction_ref_no='"+rs.getString(2) +"'");
                    conn.createStatement().executeUpdate("insert into direct_response (merchant_id,consumer_no,bd_trans_ref,bank_ref_no,transaction_amt,bank_id,bank_merchant_id,transaction_type,currency_name,item_code,security_type,security_id,security_password,transaction_date,auth_status,settlement_type,additionalinfo1_date,additionalinfo2_tran_type,additionalinfo3_trans_ref_no,additionalinfo4_bill_month,additionalinfo5_remarks,additionalinfo6,additionalinfo7,error_status,error_description,checksum,completion_ts,rebate) values('DURGAPUR','"+rs.getString(1)+"','"+rs.getString("bd_ref_no")+"','"+rs.getString("bank_ref_no")+"','"+rs.getDouble("net_amount")+"','"+rs.getString("bank_id")+"','NA','01','INR','DIRECT','NA','NA','NA','"+rs.getString("transaction_date")+"','0300','NA','"+rs.getString("transaction_date")+"','E','"+rs.getString(2)+"','"+rs.getString("bill_month")+"','"+rs.getString("remarks")+"','NA','NA','NA','Y','MANUAL','"+rs.getString("date_of_txn")+"','"+rebate+"')");
                    conn.createStatement().executeUpdate("insert into broken_log values('"+rs.getString(2)+"',NOW())");
                    
                
            }
            
            adjustSuccesasPerTransaction();
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    
}
