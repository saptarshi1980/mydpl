

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PowerDepttAuth
 */
@WebServlet("/PowerDepttAuth")
public class PowerDepttAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PowerDepttAuth() {
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
		String uidp=request.getParameter("uid").toString();
    	String password=request.getParameter("pass").toString();
    	String query="select * from govt_user_master where uid='"+uidp+"' and AES_DECRYPT(PASSWORD,PASSWORD('saptarshi'))='"+password+"'  ";
    	try{
    		Connection conn=new ConnDB().make_connection();
    		ResultSet rs=conn.createStatement().executeQuery(query);
    		int counter=0;
    		while(rs.next()){
    			
    			counter++;
    		}
    		
    		if(counter!=0){
    			
    			request.getSession().setAttribute("uidp", uidp);
    			request.getRequestDispatcher("/WEB-INF/jsp/pshowNewCons.jsp").forward(request, response);
    		}
    		else
    			request.getRequestDispatcher("/WEB-INF/jsp/powerdepttlogin.jsp").forward(request, response);
    			
    		
    	}catch(SQLException ex){
    		ex.printStackTrace();
    	}
	}

}
