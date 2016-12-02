

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
 * Servlet implementation class UpdateHandler
 */
@WebServlet("/UpdateHandler")
public class UpdateHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHandler() {
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
		String conNo=request.getSession().getAttribute("con_no").toString();
		/*String msg=request.getParameter("msg");
		String cmpl_app_form=request.getParameter("cmpl_app_form");
		String site_inspection=request.getParameter("site_inspection");
		String bom_prep=request.getParameter("bom_prep");
		String bom_issuance=request.getParameter("bom_issuance");
		String job_completion=request.getParameter("job_completion");
		String demand_rate=request.getParameter("demand_rate");
		String demand_rate_amt=request.getParameter("demand_rate_amt");
		String demand_note=request.getParameter("demand_note");
		String demand_note_amt=request.getParameter("demand_note_amt");
		String security_deposit=request.getParameter("security_deposit");
		String security_deposit_amt=request.getParameter("security_deposit_amt");
		String agreement=request.getParameter("agreement");
		String elect_clearance=request.getParameter("elect_clearance");
		String work_order=request.getParameter("work_order");
		String connection=request.getParameter("connection");
		String date_1=request.getParameter("date_1");
		String date_2=request.getParameter("date_2");
		String date_3=request.getParameter("date_3");
		String date_4=request.getParameter("date_4");
		String date_5=request.getParameter("date_5");
		String date_6=request.getParameter("date_6");
		String date_7=request.getParameter("date_7");
		String date_8=request.getParameter("date_8");
		String date_9=request.getParameter("date_9");
		String date_10=request.getParameter("date_10");
		String date_11=request.getParameter("date_11");
		String date_12=request.getParameter("date_12");
		try{
			Connection conn=new ConnDB().make_connection();	
			String insertQuery="update con_status set  rcpt_app_form=?,site_inspection=?,bom_prep=?,job_cmpl_cert=?,demand_rate=?,demand_note=?,security_deposit=?,agreement=?,clearance_elect=?,work_order=?,connection=?,message=?,bom_issuance=?,date_1=str_to_date(?,'%d-%m-%Y'),date_2=str_to_date(?,'%d-%m-%Y'),date_3=str_to_date(?,'%d-%m-%Y'),date_4=str_to_date(?,'%d-%m-%Y'),date_5=str_to_date(?,'%d-%m-%Y'),date_6=str_to_date(?,'%d-%m-%Y'),date_7=str_to_date(?,'%d-%m-%Y'),date_8=str_to_date(?,'%d-%m-%Y'),date_9=str_to_date(?,'%d-%m-%Y'),date_10=str_to_date(?,'%d-%m-%Y'),date_11=str_to_date(?,'%d-%m-%Y'),date_12=str_to_date(?,'%d-%m-%Y') where temp_con_no='"+conNo+"'";
			PreparedStatement pstmt=conn.prepareStatement(insertQuery);
			pstmt.setString(1,cmpl_app_form);
			pstmt.setString(2,site_inspection);
			pstmt.setString(3,bom_prep);
			pstmt.setString(4,job_completion);
			pstmt.setString(5,demand_rate);
			pstmt.setString(6,demand_note);
			pstmt.setString(7,security_deposit);
			pstmt.setString(8,agreement);
			pstmt.setString(9,elect_clearance);
			pstmt.setString(10,work_order);
			pstmt.setString(11,connection);
			pstmt.setString(12,msg);
			pstmt.setString(13,bom_issuance);
			pstmt.setString(14,date_1);
			pstmt.setString(15,date_2);
			pstmt.setString(16,date_3);
			pstmt.setString(17,date_4);
			pstmt.setString(18,date_5);
			pstmt.setString(19,date_6);
			pstmt.setString(20,date_7);
			pstmt.setString(21,date_8);
			pstmt.setString(22,date_9);
			pstmt.setString(23,date_10);
			pstmt.setString(24,date_11);
			pstmt.setString(25,date_12);
			pstmt.executeUpdate();
					
			request.getSession().setAttribute("custNo", conNo);
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
*/
		String options=request.getParameter("select").toString();
		String value=request.getParameter("select2").toString();
		String date=request.getParameter("date").toString();
		Connection conn=new ConnDB().make_connection();	
		
		try{
			
		
			
		
		if(options.equals("Receipt of Completed Application Form"))
        {
			PreparedStatement pstmt=conn.prepareStatement("update con_status set  rcpt_app_form='"+value+"',date_1=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
			/*RequestDispatcher rd=request.getRequestDispatcher("Option1.jsp");
            rd.forward(request, response);*/
        }
        else if(options.equals("Site Inspection"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  site_inspection='"+value+"',date_2=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
			
        	/*RequestDispatcher rd=request.getRequestDispatcher("Option2.jsp");
            rd.forward(request, response);*/
        }
		
        else if(options.equals("Commercial Clearance"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  commercial_clearance='"+value+"',date_comm=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
			
        	/*RequestDispatcher rd=request.getRequestDispatcher("Option2.jsp");
            rd.forward(request, response);*/
        }
		
		
		
        else if(options.equals("Preparation of BOM"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  bom_prep='"+value+"',date_3=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
        else if(options.equals("Job Completion Certificate received ?"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  job_cmpl_cert='"+value+"',date_4=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
		
        else if(options.equals("Issuance of Demand rate for Supervision Charges Service Charges"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  demand_rate='"+value+"',date_5=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
		
        else if(options.equals("Issuance of Demand Note for Security Deposit"))
        {
        	String dnAmt=request.getParameter("amt").toString();
        	if(dnAmt.length()==0){
        		dnAmt="0";
        	}
        	System.out.println("AMT="+dnAmt);
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  demand_note='"+value+"',date_6=str_to_date('"+date+"','%d/%m/%Y'),dn_amt='"+dnAmt+"' where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
		
        else if(options.equals("Receipt of Security Deposit"))
        {
        	String sdAmt=request.getParameter("amt").toString();
        	if(sdAmt.length()==0){
        		sdAmt="0";
        	}
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  security_deposit='"+value+"',date_7=str_to_date('"+date+"','%d/%m/%Y'),sd_amt='"+sdAmt+"' where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
		
        else if(options.equals("Agreement"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  agreement='"+value+"',date_8=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
        else if(options.equals("Clearance from Electrical Inspector(For HT Consumer only)"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  clearance_elect='"+value+"',date_9=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
		
        else if(options.equals("Connection"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set  connection='"+value+"',date_10=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
		
        else if(options.equals("Work Order"))
        {
        	PreparedStatement pstmt=conn.prepareStatement("update con_status set work_order='"+value+"',date_11=str_to_date('"+date+"','%d/%m/%Y') where temp_con_no='"+conNo+"'");
			pstmt.executeUpdate();
        }
		
		
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/editsuccess.jsp").forward(request, response);
		
		
	}

}
