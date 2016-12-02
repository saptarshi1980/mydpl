package in.net.dpl;
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
@WebServlet("/GetDateHistory")
public class GetDateHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDateHistory() {
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
		String date=request.getParameter("date").toString();
		System.out.println("Date-"+date);
		
		String noOfTran=null;
		double amount=0.0;
		double grossAmt=0.0;
    	try{
			
    		Connection conn=new ConnDB().make_connection();	
    		
			ResultSet rs=conn.createStatement().executeQuery("select count(*),sum(net_amount),SUM(gross_amt) from billdesk_mis_settled where mis_date=str_to_date('"+date+"','%d-%m-%Y') ");
			while(rs.next()){
				noOfTran=rs.getString(1);
				amount=rs.getDouble(2);
				grossAmt=rs.getDouble(3);
			}
			
							
												
		}catch(SQLException ex){
			ex.printStackTrace();
			
		}
    	request.setAttribute("msg", "CSV Uploaded. Record Count="+noOfTran+", Gross Amount=Rs "+grossAmt+", Net Amount=Rs "+amount); 
    
		
		
		request.getRequestDispatcher("/WEB-INF/JSP/resultHist.jsp").forward(request, response);
	}

}
