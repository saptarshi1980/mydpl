// Decompiled by DJ v3.12.12.99 Copyright 2015 Atanas Neshkov  Date: 3/25/2015 4:57:54 PM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SAdminAuth.java

package utility;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import system.ConnDB;

@WebServlet("/verifycon")
public class VerifyCon extends HttpServlet
{

    public VerifyCon()
    {
    }

    protected void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        
        String conNo = request.getParameter("conNo").toString();
        request.getSession().setAttribute("conNo", conNo);
        
        String query = "SELECT DISTINCT bill_prd FROM x_bill where party_code='"+conNo+"' ORDER BY bill_date desc ";
        Connection con = null;
        ArrayList billMonth = new ArrayList();
        try
        {
            con = new ConnDB().make_connection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            int counter = 0;
          
            while(rs.next()) 
            {
                System.out.println("Inside DO post Resultset");
                counter++;
                billMonth.add(rs.getString("bill_prd"));
            	
            }
            if(counter > 0)
            {
                
            	request.setAttribute("billMonth", billMonth);
            	RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/jsp/billPeriodSelector.jsp");
                reqDispatcher.forward(request, response);
            } else
            {
                //request.getSession().setAttribute("msg1", "Invalid User Credentials");
            	
                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp");
                reqDispatcher.forward(request, response);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void insertData(String pwd)
    {
        try
        {
            Connection con = (new ConnDB()).make_connection();
            Statement ps = con.createStatement();
            ps.executeUpdate("insert into superlog(emp_code,login_time) values('"+pwd+"',now())");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    private static final long serialVersionUID = 1L;
}
