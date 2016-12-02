package updateinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateInfo
 */
@WebServlet("/UpdateInfo")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
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

		String party_code=request.getParameter("party_code");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		System.out.println("Party Code-"+party_code);
		try{
			Connection conn=new ConnDB().make_connection();	
			String updateQuery="update m_party set mob_no='"+mobile+"',email_id='"+email+"',update_flag='Y' where party_code='"+party_code+"'";
			System.out.println("Query-"+updateQuery);
			Statement pstmt=conn.createStatement();
			pstmt.executeUpdate(updateQuery);
			response.sendRedirect("success.jsp");
		}catch(SQLException ex){
			ex.printStackTrace();
		}


		
	}

}
