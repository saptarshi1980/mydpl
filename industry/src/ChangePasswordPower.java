

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePasswordPower")
public class ChangePasswordPower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordPower() {
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
		
		
		String pwd=request.getParameter("pwd1");
		String uidp=request.getSession().getAttribute("uidp").toString();
		try{
			Connection conn=new ConnDB().make_connection();	
			String insertQuery="update govt_user_master set password=AES_ENCRYPT('"+pwd+"',PASSWORD('saptarshi'))  where uid='"+uidp+"'";
			Statement pstmt=conn.createStatement();
			pstmt.executeUpdate(insertQuery);
			request.getRequestDispatcher("index.jsp").forward(request, response);
									
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		
		
	}

}
