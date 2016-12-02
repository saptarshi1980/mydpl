// Decompiled by DJ v3.12.12.99 Copyright 2015 Atanas Neshkov  Date: 3/25/2015 4:55:47 PM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   EmpAuth.java


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

@WebServlet("/ValidateConsumer.dpl")
public class ValidateConsumer extends HttpServlet
{

    public ValidateConsumer()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
        {
            
    	String con_no=request.getParameter("con_no").toString();
    	String password=request.getParameter("password").toString();
    	
      	String query="select 1 from user_master where con_no='"+con_no+"' and AES_DECRYPT(USER_PASSWORD,'saptarshi')='"+password+"' ";
    	try{
    		Connection conn=new ConnDB().make_connection();
    		ResultSet rs=conn.createStatement().executeQuery(query);
    		int counter=0;
    		while(rs.next()){
    			
    			counter++;
    		}
    		
    		if(counter!=0){
    			
    			request.getSession().setAttribute("con_no", con_no);
    			request.getRequestDispatcher("/WEB-INF/jsp/userHome.jsp").forward(request, response);
    		}
    		else
    			request.getRequestDispatcher("/index.jsp").forward(request, response);
    			
    		
    	}catch(SQLException ex){
    		ex.printStackTrace();
    	}
    	
    	
    	
        }

}
