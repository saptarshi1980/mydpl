

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class SearchCon
 */
@WebServlet("/SearchCon")
public class SearchCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCon() {
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
		
		
		String fName="%"+request.getParameter("fname")+"%";
		request.getSession().setAttribute("fName", fName);
		try{
			Connection conn=new ConnDB().make_connection();	
			String searchQuery="SELECT * FROM new_consumer WHERE applicant_fname LIKE '"+fName+"' ";
			Statement pstmt=conn.createStatement();
			ResultSet rs=pstmt.executeQuery(searchQuery);
			int counter=0;
			while(rs.next()){
				counter++;
			}
			
			if(counter==0){
				request.getRequestDispatcher("/WEB-INF/jsp/recordnotfound.jsp").forward(request, response);
			}
			else{
				
				request.getRequestDispatcher("/WEB-INF/jsp/recordfound.jsp").forward(request, response);
			}
			
									
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		
		
		
		
		
	}

}
