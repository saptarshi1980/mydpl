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
 * Servlet implementation class DPLHandler
 */
@WebServlet("/GetDateDownloadOther")
public class GetDateDownloadOther extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDateDownloadOther() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/jsp/showNewCons.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date=request.getParameter("text").toString();
		request.setAttribute("date", date);
		try{
			Connection conn=new ConnDB().make_connection();	
			String selectQuery="select * from upload_master where date_format(upload_date,'%d-%m-%Y')='"+date+"' and head='PROVISIONAL' ";
			Statement pstmt=conn.createStatement();
			ResultSet rs=pstmt.executeQuery(selectQuery);
			int counter=0;
			while(rs.next()){
				
				counter++;
			}
			if(counter>0){
				
				request.setAttribute("date", date);
				request.getRequestDispatcher("otherDownloadFile.jsp").forward(request, response);
				
			}
			
			else request.getRequestDispatcher("nofile.jsp").forward(request, response);
									
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		//request.getRequestDispatcher("initialUploadFile.jsp").forward(request, response);
	}

}
