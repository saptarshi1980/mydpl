package in.net.dpl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import java.sql.*;
/**

 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
    //private final String UPLOAD_DIRECTORY = "c:/uploads/initial";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//System.out.println("Inside FileUpload Server");
    	String currDate=request.getSession().getAttribute("date").toString();
    	System.out.println("Curr Date-"+currDate);
    	String subforlder=null;
    	String success=null;
    	PrintWriter out = response.getWriter();
    	
    	try{
			Connection conn=new ConnDB().make_connection();	
			String selectQuery="select * from billdesk_mis_settled where date_format(mis_date,'%d-%m-%Y')='"+currDate+"' ";
			Statement pstmt=conn.createStatement();
			ResultSet rs=pstmt.executeQuery(selectQuery);
			int counter=1;
			while(rs.next()){
				
				counter++;
			}
			
			//subforlder=String.valueOf(counter);
			
			if(counter>1)
			{
				request.getRequestDispatcher("/WEB-INF/JSP/uploadFile.jsp").forward(request, response);
			}
									
		}catch(SQLException ex){
			ex.printStackTrace();
		}
    	//String UPLOAD_DIRECTORY = "C:/uploads/initial/"+currDate+"/"+subforlder;
    	String UPLOAD_DIRECTORY = "/usr/billdesk/upload/"+currDate;
        //process only if its multipart content
    	File file = new File(UPLOAD_DIRECTORY); 
    	FileUtils.forceMkdir(file);
    	if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        System.out.println("File Name-"+name);
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        success=updateDB(currDate, UPLOAD_DIRECTORY+"/"+name);
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", success);
            } catch (Exception ex) {
               ex.printStackTrace();
               request.setAttribute("message", "File Upload Failed due to " + ex);
               out.println("Error Occurred");
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/WEB-INF/JSP/result.jsp").forward(request, response);
     
    }
    
    public String updateDB(String currDate,String file) throws SQLException{
    	String noOfTran=null;
		double amount=0.0;
    	try{
			
    		Connection conn=new ConnDB().make_connection();	
    		conn.createStatement().executeUpdate("delete from billdesk_mis_settled_tempo ");
			String insertQuery="LOAD DATA LOCAL INFILE '"+file+"' INTO TABLE billdesk_mis_settled_tempo FIELDS TERMINATED BY ',' (biller_id,bank_id,bank_ref_no,bd_ref_no,con_no,@transaction_date, transaction_type,transaction_ref_no,bill_month,remarks,ref7,ref8,filler,@date_of_txn,@settlement_date,gross_amt,charges,service_tax,net_amount) SET transaction_date = STR_TO_DATE(@transaction_date,'%d%m%y'),date_of_txn = STR_TO_DATE(@date_of_txn,'%d/%m/%Y %H:%i:%s'),settlement_date = STR_TO_DATE(@settlement_date,'%d/%m/%Y %H:%i:%s')";
			Statement pstmt1=conn.createStatement();
			pstmt1.executeUpdate(insertQuery);
			conn.createStatement().executeUpdate("update billdesk_mis_settled_tempo set mis_date=str_to_date('"+currDate+"','%d-%m-%Y')");
			conn.createStatement().executeUpdate("insert into billdesk_mis_settled select * from billdesk_mis_settled_tempo");
			ResultSet rs=conn.createStatement().executeQuery("select count(*),sum(net_amount) from billdesk_mis_settled_tempo where mis_date=str_to_date('"+currDate+"','%d-%m-%Y') ");
			while(rs.next()){
				noOfTran=rs.getString(1);
				amount=rs.getDouble(2);
			}
			
			//return "CSV Uploaded. Record Count="+noOfTran+", Amount="+amount;
			
			new AdjustBrokenTransaction().adjust();
			new AdjustBrokenTransaction().adjustMisc();
			new AdjustBrokenTransaction().adjustAsPerBilldeskSettled();
					
												
		}catch(SQLException ex){
			ex.printStackTrace();
			return "Some Error has occured, Please ensure that you have uploaded the CSV file pertaining to the selected date because duplicate data has been detected";
		}
    	return "CSV Uploaded. Record Count="+noOfTran+", Amount="+amount;
    }
  
}

