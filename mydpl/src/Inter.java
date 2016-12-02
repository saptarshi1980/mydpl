

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import domain.BillInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.security.*;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/Inter.dpl")
public class Inter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inter() {
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
		
		/*System.out.println("========== At DPL Bill Payment Portal.........Ready To Dispatch Consumer's Request To Bill Desk Portal ============");
		String name=request.getParameter("name").toString();
		String amt= request.getParameter("amt").toString();
		String msg=name+"|"+amt;
		
		Cookie loginCookie = new Cookie("user",request.getSession().getId());
        loginCookie.setMaxAge(30*60);
        response.addCookie(loginCookie);
		request.getSession().setAttribute("msg", msg);
		response.sendRedirect("ForwardToGateway.dpl");*/
		
		//request.getRequestDispatcher("gateway.jsp").forward(request, response);
if(request.getParameter("a") != null){
		
		
	String billMonth=request.getParameter("a").toString();
		String consNo=request.getParameter("con_no").toString();
		String rebate=request.getParameter("rebate").toString();
		String query="SELECT bill_month,bill_amt FROM v_bill_info WHERE party_code='"+consNo+"' AND DATE_FORMAT(STR_TO_DATE(bill_month,'%y%m'),'%M-%Y')='"+billMonth+"'";	
		Connection conn=new ConnDB().make_connection();
		String billMonthnew=null;
		String billAmt=null;
		try{
			
			ResultSet rs=conn.createStatement().executeQuery(query);
					while(rs.next()){
						billMonthnew=rs.getString(1);
						billAmt=rs.getString(2);
					}
						
					}catch(SQLException ex){
						ex.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			//billAmt="2.00";
	    	String ChecksumKey ="a3VkNtgWZNwu";
			//String transactionRefNo=getDate()+System.nanoTime();
	    	new Unique();
			String transactionRefNo=String.valueOf(Unique.get());
			String transactionDate=getDate();
			String ru="https://thedpl.in/mydpl/bdresponse";
			//String ip=request.getRemoteAddr()+"-"+rebate;
			String ip=request.getHeader("X-FORWARDED-FOR")+"-"+rebate;
			String msg=new CreateMessage().createMessage("DURGAPUR", consNo,"NA", billAmt, "INR", "R", "durgapur", "F", transactionDate, "E",transactionRefNo, billMonthnew, ip,ru);
			System.out.println("MSG="+msg);
			System.out.println("Date ="+transactionDate);
			//String checkSum=HmacSHA256(msg, ChecksumKey);
			String checkSum=new ChecksumBillDesk().HmacSHA256(msg, ChecksumKey);
			String finalMessage=msg+"|"+checkSum;
			System.out.println("Final Message Parameter which will be sent to BillDesk-"+finalMessage);
			Connection connInsert=new ConnDB().make_connection();
			try{
				connInsert.createStatement().executeUpdate("insert into transaction(consumer_no,transaction_date,transaction_type,transaction_ref_no,bill_month,transaction_amt,remarks,original_status,final_status,billdesk_status,initiation_ts,original_msg,checksum) values('"+consNo+"',str_to_date('"+transactionDate+"','%d%m%y'),'E','"+transactionRefNo+"',str_to_date('"+billMonth+"','%M-%Y'),'"+billAmt+"','"+ip+"','PENDING','PENDING','0000',NOW(),'"+msg+"','"+checkSum+"')");
				
			}catch(SQLException ex){
				ex.printStackTrace();
			}finally{
				try {
					connInsert.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			request.setAttribute("msg", finalMessage);
			request.getRequestDispatcher("finalgateway.jsp").forward(request, response);
	}
else{
	response.sendRedirect("index.jsp");
}


}
	
	public String getDate(){
		
		String PATTERN="ddMMyy";
		SimpleDateFormat dateFormat=new SimpleDateFormat();
		dateFormat.applyPattern(PATTERN);
		String currDate=dateFormat.format(Calendar.getInstance().getTime());
		return currDate; 
	}
	
	/*public String HmacSHA256(String message,String secret)  {
		MessageDigest md = null;
			try {

				Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
				 SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
				 sha256_HMAC.init(secret_key);
				byte raw[] = sha256_HMAC.doFinal(message.getBytes());
				StringBuffer ls_sb=new StringBuffer();
				for(int i=0;i<raw.length;i++)
					ls_sb.append(char2hex(raw[i]));
					return ls_sb.toString(); //step 6
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	public static String char2hex(byte x)
	{
	    char arr[]={
	                  '0','1','2','3',
	                  '4','5','6','7',
	                  '8','9','A','B',
	                  'C','D','E','F'
	                };

	    char c[] = {arr[(x & 0xF0)>>4],arr[x & 0x0F]};
	    return (new String(c));
	  }*/
	
	
	

}
