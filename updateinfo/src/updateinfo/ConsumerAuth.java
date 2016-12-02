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
 * Servlet implementation class ConsumerAuth
 */
@WebServlet("/ConsumerAuth")
public class ConsumerAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsumerAuth() {
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
		
		
		String consumerNumber=request.getParameter("con_no");
		String meter_no=request.getParameter("meter_no").toUpperCase();
		String name=null;
		try{
			Connection conn=new ConnDB().make_connection();	
			String selectQuery="SELECT DISTINCT a.party_code,b.meter_no,a.name FROM m_party a,x_bill b WHERE a.party_code='"+consumerNumber+"' AND b.meter_no='"+meter_no+"' and a.party_code=b.party_code ORDER BY a.party_code ";
			Statement pstmt=conn.createStatement();
			ResultSet rs=pstmt.executeQuery(selectQuery);
			int counter=0;
			while(rs.next()){
				
				counter++;
				name=rs.getString(3);
				
			}
			if(counter>0){
				
				request.setAttribute("name", name);
				request.setAttribute("party_code", consumerNumber);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				
			}
			else{
				request.getRequestDispatcher("index.html").forward(request, response);
			}
			
			
									
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		
	}

}
