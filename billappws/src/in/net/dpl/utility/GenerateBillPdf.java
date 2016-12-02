package in.net.dpl.utility;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;




public class GenerateBillPdf {

	public void generatePdf(String conNo){
		
		String billPrd="abc";
		String sourceFileName = "/usr/rpt_file/electricbill.jasper";
		String printFileName = null;
		Map params = new HashMap();
        params.put("consumer_no",conNo);
        params.put("bill_prd",billPrd);
        
        try{
        	
        	Connection conn = new ConnDB().make_connection();
        	printFileName = JasperFillManager.fillReportToFile(sourceFileName,params, conn);
        	JasperExportManager.exportReportToPdfFile(printFileName,"/usr/tomcat/webapps/billreport/"+conNo+".pdf");
        	
        	
        }catch (JRException e) {
            e.printStackTrace();
        }
        
		
	}
	
}
