<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<%@ page import="java.util.Date;import java.text.SimpleDateFormat;" %>
<%@ page errorPage="ShowError.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Consumer Data</title>

</head>
<body >

<a href="pRedirectShowNewCons"><span>New Consumer Home</span></a>
<br>
<br>
<A HREF="index.jsp">HOME</A>
<BR>
<BR>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://192.168.30.7:3306/dplsw"
        user="remote" password="dgppro1961"
    />
    
    <%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

    String strDate = sdf.format(date);
    

    
    sdf = new SimpleDateFormat("dd-MM-yyyy");
    strDate = sdf.format(date);
    
    
    %>
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        <%
        String conNumber = request.getSession().getAttribute("con_no").toString().trim();
        session.setAttribute("con_no", conNumber);
        
    	%>
        SELECT a.temp_con_no,a.conn_load,a.conn_phase,a.unit_name,a.unit_address1,a.unit_address2,a.unit_pincode,a.unit_landmark,a.unit_landline,a.unit_mobile,a.applicant_fname,a.applicant_lname,a.applicant_address1,a.applicant_address2,a.applicant_pincode,a.applicant_landline,a.applicant_mobile,a.name_ref1,a.address_ref1,a.name_ref2,a.address_ref2,a.entry_date,B.Agreement,B.BOM_prep,B.clearance_elect,B.connection,B.Demand_note,B.Demand_rate,B.job_cmpl_cert,B.message,B.rcpt_app_form,B.security_deposit,B.site_inspection,B.work_order,B.BOM_ISSUANCE,DATE_FORMAT(B.date_1,'%d-%m-%Y') as date_1,DATE_FORMAT(B.date_2,'%d-%m-%Y') as date_2,DATE_FORMAT(B.date_3,'%d-%m-%Y') as date_3,DATE_FORMAT(B.date_4,'%d-%m-%Y') as date_4,DATE_FORMAT(B.date_5,'%d-%m-%Y') as date_5,DATE_FORMAT(B.date_6,'%d-%m-%Y') as date_6,DATE_FORMAT(B.date_7,'%d-%m-%Y') as date_7,DATE_FORMAT(B.date_8,'%d-%m-%Y') as date_8,DATE_FORMAT(B.date_9,'%d-%m-%Y') as date_9,DATE_FORMAT(B.date_10,'%d-%m-%Y') as date_10,DATE_FORMAT(B.date_11,'%d-%m-%Y') as date_11,DATE_FORMAT(B.date_12,'%d-%m-%Y') as date_12 FROM new_consumer a,con_status b WHERE TRIM(A.temp_con_no)='<%= conNumber%>' AND A.temp_con_no=B.temp_con_no
    </sql:query>
     
<div align="center">
        <form name="form1" method="post" action="UpdateHandler">
          <table border="1" cellpadding="5">
            <caption>
            <h2>DPL-Consumer Details</h2>
            </caption>
            <tr>
              <th>Temp Connection No</th>
              <th>Load</th>
              <th>Phase</th>
              <th>Name of the Unit</th>
              <th>Address1</th>
              <th>Address2</th>
              <th>Pin Code</th>
              <th>Land Mark</th>
              <th>Land Line </th>
              <th>Mobile</th>
              <th>Applicant First Name</th>
              <th>Applicant Second Name</th>
              <th>Applicant Address</th>
              <th>Applicant Address</th>
              <th>Applicant Pin Code</th>
              <th>Applicant Land Line</th>
              <th>Applicant Mobile</th>
              <th>Referee Name</th>
              <th>Referee Address</th>
              <th>Referee Name</th>
              <th>Referee Address</th>
              <th>Entry Date and Time</th>
              <th>Receipt of App Form</th>
              <th>Site Inspection</th>
              <th>Preparartion of BOM</th>
              <th>Job Completion Certificate received ?</th>
              <th>Issuance of Demand rate for Supervision Charges Service Charges</th>
              <th>Issuance of Demand Note for Security Deposit</th>
              <th>Receipt of Security Deposit</th>
              <th>Agreement</th>
              <th>Clearance from Electrical Inspector(For HT Consumer only)</th>
              <th>Work Order</th>
              <th>BOM Issuance</th>
              
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
              <tr>
                <td><c:out value="${user.temp_con_no}" /></td>
                <td><c:out value="${user.conn_load}" /></td>
                <td><c:out value="${user.conn_phase}" /></td>
                <td><c:out value="${user.unit_name}" /></td>
                <td><c:out value="${user.unit_address1}" /></td>
                <td><c:out value="${user.unit_address2}" /></td>
                <td><c:out value="${user.unit_pincode}" /></td>
                <td><c:out value="${user.unit_landmark}" /></td>
                <td><c:out value="${user.unit_landline}" /></td>
                <td><c:out value="${user.unit_mobile}" /></td>
                <td><c:out value="${user.applicant_fname}" /></td>
                <td><c:out value="${user.applicant_lname}" /></td>
                <td><c:out value="${user.applicant_address1}" /></td>
                <td><c:out value="${user.applicant_address2}" /></td>
                <td><c:out value="${user.applicant_pincode}" /></td>
                <td><c:out value="${user.applicant_landline}" /></td>
                <td><c:out value="${user.applicant_mobile}" /></td>
                <td><c:out value="${user.name_ref1}" /></td>
                <td><c:out value="${user.address_ref1}" /></td>
                <td><c:out value="${user.name_ref2}" /></td>
                <td><c:out value="${user.address_ref2}" /></td>
                <td><c:out value="${user.entry_date}" /></td>
                <td><c:out value="${user.rcpt_app_form}" />(<c:out value="${user.date_1}" />)</td>
                <td><c:out value="${user.site_inspection}" />(<c:out value="${user.date_2}" />)</td>
                <td><c:out value="${user.bom_prep}" />(<c:out value="${user.date_3}" />)</td>
                <td><c:out value="${user.job_cmpl_cert}" />(<c:out value="${user.date_4}" />)</td>
                <td><c:out value="${user.demand_rate}" />(<c:out value="${user.date_5}" />)</td>
                <td><c:out value="${user.demand_note}" />(<c:out value="${user.date_6}" />)</td>
                <td><c:out value="${user.security_deposit}" />(<c:out value="${user.date_7}" />)</td>
                <td><c:out value="${user.agreement}" />(<c:out value="${user.date_8}" />)</td>
                <td><c:out value="${user.clearance_elect}" />(<c:out value="${user.date_9}" />)</td>
                <td><c:out value="${user.work_order}" />(<c:out value="${user.date_10}" />)</td>
                <td><c:out value="${user.BOM_ISSUANCE}" />(<c:out value="${user.date_11}" />)</td>
              </tr>
            </c:forEach>
          </table>
          <p align="left">&nbsp;</p>
        <p align="left">
            <label></label>
            <label></label>
          </p>
          <p align="left">&nbsp;</p>
  </form>
        <p align="left">&nbsp; </p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
 </form>
</body>
</html>