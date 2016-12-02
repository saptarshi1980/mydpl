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

@WebServlet("/ValidateConsumerRegister.dpl")
public class ValidateConsumerRegister extends HttpServlet
{

    public ValidateConsumerRegister()
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
    	String meter_no=request.getParameter("meter_no").toString().toUpperCase();
    	
      	String query="SELECT party_code,NAME,CONCAT(IFNULL(address1,' '),IFNULL(address2,' '),IFNULL(address3,' ')) AS address,meter_no,ifnull(mob_no,' ') as mob_no,ifnull(email_id,' ') as email_id FROM v_party_info where con_no='"+con_no+"' and meter_no='"+meter_no+"' ";
    	try{
    		Connection conn=new ConnDB().make_connection_consdb();
    		ResultSet rs=conn.createStatement().executeQuery(query);
    		
    		String name=null;
    		String address=null;
    		String mob_no=null;
    		String email_id=null;
    		
    		
    		int counter=0;
    		while(rs.next()){
    			
    			counter++;
    			name=rs.getString("name");
    			address=rs.getString("address");
    			mob_no=rs.getString("mob_no");
    			email_id=rs.getString("email_id");
    			
    			
    		}
    		
    		if(counter!=0){
    			
    			request.getSession().setAttribute("con_no", con_no);
    			request.getSession().setAttribute("meter_no", meter_no);
    			request.getSession().setAttribute("name", name);
    			request.getSession().setAttribute("address", address);
    			request.getSession().setAttribute("mob_no", mob_no);
    			request.getSession().setAttribute("email_id", email_id);
    			request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp").forward(request, response);
    		}
    		else
    			request.getRequestDispatcher("/index.jsp").forward(request, response);
    			
    		
    	}catch(SQLException ex){
    		ex.printStackTrace();
    	}
    	
    	
    	request.getRequestDispatcher("/WEB-INF/jsp/userEntry.jsp").forward(request, response);
    	
        }

}
