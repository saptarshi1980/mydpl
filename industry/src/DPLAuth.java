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

@WebServlet("/DPLAuth")
public class DPLAuth extends HttpServlet
{

    public DPLAuth()
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
    	
    	String query="select 1 from user_master where uid='"+uid+"' and AES_DECRYPT(PASSWORD,PASSWORD('saptarshi'))='"+password+"' ";
    	try{
    		Connection conn=new ConnDB().make_connection();
    		ResultSet rs=conn.createStatement().executeQuery(query);
    		int counter=0;
    		while(rs.next()){
    			
    			counter++;
    		}
    		
    		if(counter!=0){
    			
    			request.getSession().setAttribute("uid", uid);
    			request.getRequestDispatcher("/WEB-INF/jsp/showNewCons.jsp").forward(request, response);
    		}
    		else
    			request.getRequestDispatcher("/WEB-INF/jsp/dpllogin.jsp").forward(request, response);
    			
    		
    	}catch(SQLException ex){
    		ex.printStackTrace();
    	}
    	
    	
    	
        }

}
