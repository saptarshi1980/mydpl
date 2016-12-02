

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveFromGateway
 */
@WebServlet("/ReceiveFromGateway.dpl")
public class ReceiveFromGateway extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveFromGateway() {
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
		
		System.out.println("========== Returned Back To DPL Payment Portal ============");
		String status=request.getParameter("status").toString();
		System.out.println("Payment Status-"+status);
		response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<html>\n" +
	    	        "<head><title>" + " Welcome Back To DPL"+ "</title></head>\n"+
	    	        "<body bgcolor=\"#f0f0f0\">\n" );
	      out.println("<h1>" + "Welcome back to DPL Website:: Payment Status::"+status + "</h1>");
	      Cookie loginCookie = null;
	        Cookie[] cookies = request.getCookies();
	        if(cookies != null){
	        for(Cookie cookie : cookies){
	            if(cookie.getName().equals("user")){
	                loginCookie = cookie;
	                System.out.println("Login Cookie="+cookie.getValue());
	            }
	        }
	        }
	        
	        System.out.println("======END OF PAYMENT PROCESS=======");

	}

}
