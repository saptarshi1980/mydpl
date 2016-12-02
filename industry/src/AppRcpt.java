

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Servlet implementation class AppRcpt
 */
@WebServlet("/AppRcpt")
public class AppRcpt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppRcpt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempConNo = request.getSession().getAttribute("temp_con_no").toString();
	    System.out.println("Iniside PF Statement");
        response.setHeader("Content-Disposition", "attachment; filename="+tempConNo+".pdf");
        ServletOutputStream servletOutputStream = response.getOutputStream();
        
       
        
        
        
        File reportFile = new File(getServletConfig().getServletContext().getRealPath("WEB-INF/sw.jasper"));
        byte bytes[] = (byte[])null;
        
        Map params = new HashMap();
        params.put("temp_con_no",tempConNo);
       
        try
        {
            
        	Connection conn = new ConnDB().make_connection();
            bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), params, conn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            servletOutputStream.write(bytes, 0, bytes.length);
            servletOutputStream.flush();
            servletOutputStream.close();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
