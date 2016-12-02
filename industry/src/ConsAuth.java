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

@WebServlet("/ConsAuth")
public class ConsAuth extends HttpServlet
{

    public ConsAuth()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
        {
            
    	String uid=request.getParameter("uid").toString();
    	String password=request.getParameter("pass").toString();
    	
    	System.out.println("User id -"+uid);
    	System.out.println("Password -"+password);
    	String con_no=null;
    	
    	String query="select a.user_id,b.temp_con_no from user_master_consumer a,new_consumer b where a.user_id='"+uid+"' and a.password='"+password+"' and trim(a.user_id)=trim(b.user_id)";
    	try{
    		Connection conn=new ConnDB().make_connection();
    		ResultSet rs=conn.createStatement().executeQuery(query);
    		int counter=0;
    		while(rs.next()){
    			
    			counter++;
    			con_no=rs.getString(2);
    		}
    		
    		if(counter!=0){
    			
    			request.getSession().setAttribute("con_no", con_no);
    			request.getRequestDispatcher("/WEB-INF/jsp/showStatus.jsp").forward(request, response);
    		}
    		else
    			request.getRequestDispatcher("/WEB-INF/jsp/conslogin.jsp").forward(request, response);
    			
    		
    	}catch(SQLException ex){
    		ex.printStackTrace();
    	}
    	
    	
    	
        }

}
