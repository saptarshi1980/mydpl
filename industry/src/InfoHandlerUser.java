

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class StoreConnectionInfo
 */
@WebServlet("/InfoHandlerUser")
public class InfoHandlerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoHandlerUser() {
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
			
		String load=request.getParameter("load");
		String phase=request.getParameter("phase");
		String unit_name=request.getParameter("unit_name");
		String address1=request.getParameter("address1");
		String address2=request.getParameter("address2");
		String pinCode=request.getParameter("pin_code");
		String landmark=request.getParameter("landmark");
		String landline=request.getParameter("landline");
		String mobile=request.getParameter("mobile");
		
		String applicantFirstName=request.getParameter("applicant_first_name");
		String applicantLastName=request.getParameter("applicant_last_name");
		String applicantAddress1=request.getParameter("applicant_address1");
		String applicantAddress2=request.getParameter("applicant_address2");
		String applicantPinCode=request.getParameter("applicant_pincode");
		String applicantLandLine=request.getParameter("applicant_landline");
		String applicantMobile=request.getParameter("applicant_mobile");
		
		System.out.println("Land Line-"+applicantLandLine);
		
		String referee1=request.getParameter("referee1_name");
		String referee1Adderess=request.getParameter("referee1_address");
		String referee2=request.getParameter("referee2_name");
		String referee2Adderess=request.getParameter("referee2_address");
		String category="IND";
		/*String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		   if (ipAddress == null) {  
			   ipAddress = request.getRemoteAddr();  
		   }*/
		
		String ipAddress=getIpAddr(request);
		
		try{
			Connection conn=new ConnDB().make_connection();	
			String insertQuery="insert into new_consumer(conn_load,conn_phase,unit_name,unit_address1,unit_address2,unit_pincode,unit_landmark,unit_landline,unit_mobile,applicant_fname,applicant_lname,applicant_address1,applicant_address2,applicant_pincode,applicant_landline,applicant_mobile,name_ref1,address_ref1,name_ref2,address_ref2,temp_con_no,entry_date,category,ip) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),'"+category+"','"+ipAddress+"')";
			PreparedStatement pstmt=conn.prepareStatement(insertQuery);
			pstmt.setString(1,load);
			pstmt.setString(2,phase);
			pstmt.setString(3,unit_name);
			pstmt.setString(4,address1);
			pstmt.setString(5,address2);
			pstmt.setString(6,pinCode);
			pstmt.setString(7,landmark);
			pstmt.setString(8,landline);
			pstmt.setString(9,mobile);
			pstmt.setString(10,applicantFirstName);
			pstmt.setString(11,applicantLastName);
			pstmt.setString(12,applicantAddress1);
			pstmt.setString(13,applicantAddress2);
			pstmt.setString(14,applicantPinCode);
			pstmt.setString(15,applicantLandLine);
			pstmt.setString(16,applicantMobile);
			pstmt.setString(17,referee1);
			pstmt.setString(18,referee1Adderess);
			pstmt.setString(19,referee2);
			pstmt.setString(20,referee2Adderess);
			PreparedStatement pstmtrowcount=conn.prepareStatement("SELECT COUNT(*) FROM new_consumer");
			PreparedStatement pstmtstatus=conn.prepareStatement("insert into con_status(temp_con_no,date_1,date_2,date_3,date_4,date_5,date_6,date_7,date_8,date_9,date_10,date_11,date_12) values(?,now(),now(),now(),now(),now(),now(),now(),now(),now(),now(),now(),now())");
			ResultSet rs=pstmtrowcount.executeQuery();
			int counter=0;
			while(rs.next()){
				counter=rs.getInt(1);
			}
			counter++;
			String custNo="DPL/"+counter;
			pstmt.setString(21,custNo);
			pstmt.executeUpdate();
			pstmtstatus.setString(1, custNo);
			pstmtstatus.executeUpdate();
			
			request.getSession().setAttribute("custNo", custNo);
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		
	}
	
	public String getIpAddr(HttpServletRequest request) {      
		   String ip = request.getHeader("x-forwarded-for");      
		   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		       ip = request.getHeader("Proxy-Client-IP");      
		   }      
		   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		       ip = request.getHeader("WL-Proxy-Client-IP");      
		   }      
		   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		       ip = request.getRemoteAddr();      
		   }      
		   return ip;      
		} 

}
