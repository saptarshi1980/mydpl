// Decompiled by DJ v3.12.12.99 Copyright 2015 Atanas Neshkov  Date: 3/25/2015 4:58:11 PM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SalaryCertificate.java

package utility;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import system.ConnDB;
import com.itextpdf.text.DocumentException;

import domain.ITextMergeThree;
@WebServlet("/Generate")
public class Generate extends HttpServlet
{

    

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
    	
    	
    	String conNo = request.getSession().getAttribute("conNo").toString();
        String billMonth = request.getParameter("billmonth");
        System.out.println(conNo+" "+billMonth);
        byte bytes[] = null;
        
        Map params = new HashMap();
        params.put("consumer_no",conNo);
        params.put("bill_prd",billMonth);
        
        response.setHeader("Content-Disposition", "inline; filename="+"bill"+".pdf");
        ServletOutputStream servletOutputStream = response.getOutputStream();
        File reportFile = new File(getServletConfig().getServletContext().getRealPath("WEB-INF/electricbill.jasper"));
        
        
        
       
        try
        {
            
        	Connection conn = new ConnDB().make_connection();
        	conn.createStatement().executeUpdate("insert into billview (con_no,bill_prd,time_stamp) values('"+conNo+"','"+billMonth+"',NOW())");
            bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), params, conn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            servletOutputStream.write(bytes, 0, bytes.length);
            servletOutputStream.flush();
            servletOutputStream.close();
        }
        
        
       
        /*try
        {
            
        	Connection conn = new ConnDB().make_connection();
        	        	
        	JasperReport jasperReport = null;
            JasperDesign jasperDesign = null;
            String path = getServletContext().getRealPath("/WEB-INF/");
            jasperDesign = JRXmlLoader.load(path+"/electricbill.jrxml");
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, params, conn);                            
            OutputStream outStream = response.getOutputStream();
            response.setHeader("Content-Disposition","inline, filename=myReport.pdf");
            response.setContentType("application/pdf");
            response.setContentLength(byteStream.length);
            outStream.write(byteStream,0,byteStream.length); 
        	
        	
        	
        	
        	
        }
        catch(JRException e)
        {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.getOutputStream().print(stringWriter.toString());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
	*/
              
        
        catch(JRException e)
        {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.getOutputStream().print(stringWriter.toString());
            e.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        	
                
      
    }

    protected void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }

    
}
