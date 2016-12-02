package in.net.dpl;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Servlet implementation class ServiceLoginAuth
 */
@WebServlet("/ServiceLoginAuth")
public class ServiceLoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceLoginAuth() {
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
		String uid=request.getParameter("uid").toString();
    	String password=request.getParameter("pass").toString();
    	String ipRemote = request.getRemoteAddr().trim();
    	
    	System.out.println("User id -"+uid);
    	System.out.println("Password -"+password);
    	
    	String query="select * from user_master_payment_integrator where uid='"+uid+"' and AES_DECRYPT(PASSWORD,PASSWORD('saptarshi'))='"+password+"' ";
    	System.out.println("query-"+query);
    	try{
    		Connection conn=new ConnDB().make_connection();
    		ResultSet rs=conn.createStatement().executeQuery(query);
    		int counter=0;
    		while(rs.next()){
    			
    			counter++;
    		}
    		
    		//if(counter!=0 && ipRemote.matches("122.160.112.239")||ipRemote.matches("117.232.84.130")||ipRemote.matches("117.247.67.178")){
    			if(counter!=0){
    			
    			
    			//request.getRequestDispatcher("initialUploadDate.jsp").forward(request, response);
    			request.getSession().setAttribute("uid", uid);
    			request.getRequestDispatcher("/WEB-INF/JSP/dateSelector.jsp").forward(request, response);
    		}
    		else
    			request.getRequestDispatcher("index.jsp").forward(request, response);
    			
    		
    	}catch(SQLException ex){
    		ex.printStackTrace();
    	}

}
}