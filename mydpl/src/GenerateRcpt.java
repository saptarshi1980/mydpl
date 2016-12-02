

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;

import java.util.*;

/**
 * Servlet implementation class GenerateRcpt
 */
@WebServlet("/GenerateRcpt.dpl")
public class GenerateRcpt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateRcpt() {
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
	
		String conNo=request.getParameter("con_id").toString().trim();
		String query=" SELECT consumer_no,date_format(transaction_date,'%d-%m-%y') as transaction_date ,transaction_ref_no,DATE_FORMAT(bill_month,'%M-%y') AS bill_month,transaction_amt FROM transaction where consumer_no='"+conNo+"' AND billdesk_status='0300' ORDER BY transaction_date DESC LIMIT 10";	
		Connection conn=new ConnDB().make_connection();
		ArrayList<PaymentReceipt>paymentRcptAL=new ArrayList<PaymentReceipt>();
		int counter=0;
		
		try{
			
			ResultSet rs=conn.createStatement().executeQuery(query);
					while(rs.next()){
						
						PaymentReceipt rcpt=new PaymentReceipt();
						rcpt.setBillMonth(rs.getString("bill_month"));
						rcpt.setConsumerNo(rs.getString("consumer_no"));
						rcpt.setTranDate(rs.getString("transaction_date"));
						rcpt.setRefNo(rs.getString("transaction_ref_no"));
						rcpt.setTranAmt(rs.getString("transaction_amt"));
						paymentRcptAL.add(rcpt);
						counter++;
						
					}
						
					}catch(SQLException ex){
						ex.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						
						
						if(counter>0){
							request.setAttribute("info", paymentRcptAL);
							request.getRequestDispatcher("downloadRcpt.jsp").forward(request,response);	
						}
						else{
							request.getRequestDispatcher("noRcpt.jsp").forward(request,response);
						}
		
		
	}

	}
}
