

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StoreConnectionInfo
 */
@WebServlet("/StoreConnectionInfoUser")
public class StoreUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreUserInfo() {
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
		
		
	
		
		String applicantFirstName=request.getParameter("applicant_first_name");
		String applicantLastName=request.getParameter("applicant_last_name");
		String applicantAddress1=request.getParameter("applicant_address1");
		String applicantAddress2=request.getParameter("applicant_address2");
		String applicantPinCode=request.getParameter("applicant_pincode");
		String applicantLandLine=request.getParameter("applicant_landline");
		String applicantMobile=request.getParameter("applicant_mobile");
		String applicantEmail=request.getParameter("applicant_email");
		String applicantPassword=request.getParameter("applicant_password");
		
		
	try{
			Connection conn=new ConnDB().make_connection();	
			String insertQuery="insert into user_master_consumer(user_id,password,fname,lname,address1,address2,email,landline,pin) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(insertQuery);
			pstmt.setString(1,applicantMobile);
			pstmt.setString(2,applicantPassword);
			pstmt.setString(3,applicantFirstName.toUpperCase());
			pstmt.setString(4,applicantLastName.toUpperCase());
			pstmt.setString(5,applicantAddress1.toUpperCase());
			pstmt.setString(6,applicantAddress2.toUpperCase());
			pstmt.setString(7,applicantEmail);
			pstmt.setString(8,applicantLandLine);
			pstmt.setString(9,applicantPinCode);
			
			pstmt.executeUpdate();
			request.getSession().setAttribute("user_id", applicantMobile);
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/newConn.jsp").forward(request, response);
		
	}

}
