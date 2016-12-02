

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StoreConnectionInfo
 */
@WebServlet("/StoreConnectionInfo")
public class StoreConnectionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreConnectionInfo() {
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
		
		String load=request.getParameter("load");
		String phase=request.getParameter("phase");
		String unit_name=request.getParameter("unit_name");
		String address1=request.getParameter("address1");
		String address2=request.getParameter("address2");
		String pinCode=request.getParameter("pin_code");
		String landmark=request.getParameter("landmark");
		String landline=request.getParameter("landline");
		String mobile=request.getParameter("mobile");
		
		String applicantFirstName=request.getParameter("applicant_first_name");
		String applicantLastName=request.getParameter("applicant_last_name");
		String applicantAddress1=request.getParameter("applicant_address1");
		String applicantAddress2=request.getParameter("applicant_address2");
		String applicantPinCode=request.getParameter("applicant_pincode");
		String applicantLandLine=request.getParameter("applicant_landline");
		String applicantMobile=request.getParameter("applicant_mobile");
		
		System.out.println("Land Line-"+applicantLandLine);
		
		String referee1=request.getParameter("referee1_name");
		String referee1Adderess=request.getParameter("referee1_address");
		String referee2=request.getParameter("referee2_name");
		String referee2Adderess=request.getParameter("referee2_address");
		
		
		request.getSession().setAttribute("load", load.toUpperCase());
		request.getSession().setAttribute("phase", phase.toUpperCase());
		request.getSession().setAttribute("unit_name", unit_name.toUpperCase());
		request.getSession().setAttribute("address1", address1.toUpperCase());
		request.getSession().setAttribute("address2", address2.toUpperCase());
		request.getSession().setAttribute("pinCode", pinCode.toUpperCase());
		request.getSession().setAttribute("landmark", landmark.toUpperCase());
		request.getSession().setAttribute("landline", landline.toUpperCase());
		request.getSession().setAttribute("mobile", mobile.toUpperCase());
		
		
	
		
		request.getSession().setAttribute("referee1", referee1.toUpperCase());
		request.getSession().setAttribute("referee1Adderess", referee1Adderess.toUpperCase());
		request.getSession().setAttribute("referee2", referee2.toUpperCase());
		request.getSession().setAttribute("referee2Adderess", referee2Adderess.toUpperCase());
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/beforeSubmit.jsp").forward(request, response);
		
	}

}
