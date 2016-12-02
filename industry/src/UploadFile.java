import java.io.File;
import java.io.IOException;
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
    	System.out.println("Inside FileUpload Server");
    	String currDate=request.getSession().getAttribute("date").toString();
    	String subforlder=null;
    	
    	try{
			Connection conn=new ConnDB().make_connection();	
			String selectQuery="select * from upload_master where date_format(upload_date,'%d-%m-%Y')='"+currDate+"' and head='INITIAL' ";
			Statement pstmt=conn.createStatement();
			ResultSet rs=pstmt.executeQuery(selectQuery);
			int counter=1;
			while(rs.next()){
				
				counter++;
			}
			
			subforlder=String.valueOf(counter);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
									
		}catch(SQLException ex){
			ex.printStackTrace();
		}
    	//String UPLOAD_DIRECTORY = "C:/uploads/initial/"+currDate+"/"+subforlder;
    	String UPLOAD_DIRECTORY = "/usr/aldc/upload/"+currDate+"/"+subforlder;
        //process only if its multipart content
    	File file = new File(UPLOAD_DIRECTORY); 
    	FileUtils.forceMkdir(file);
    	if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        updateDB(currDate, "INITIAL", UPLOAD_DIRECTORY+"/"+name);
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/result.jsp").forward(request, response);
     
    }
    
    public void updateDB(String currDate,String head,String file){
    	
    	try{
			Connection conn=new ConnDB().make_connection();	
			String insertQuery="insert into upload_master(upload_date,head,file_path,date_time) values(str_to_date('"+currDate+"','%d-%m-%Y'),'INITIAL','"+file+"',NOW())";
			Statement pstmt=conn.createStatement();
			pstmt.executeUpdate(insertQuery);
												
		}catch(SQLException ex){
			ex.printStackTrace();
		}
    	
    }
  
}

