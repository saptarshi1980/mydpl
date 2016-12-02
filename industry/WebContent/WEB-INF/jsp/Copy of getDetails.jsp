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
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://server2:3306/dplsw"
        user="remote" password="dpl123"
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
        <table border="1" cellpadding="5">
            <caption><h2>DPL-Consumer Details</h2></caption>
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
                </tr>
            
        </table>
        <p align="left"><strong>Change the Status of the Customer according to the options available below:</strong></p>
        <form name="form1" method="post" action="UpdateHandler">
       
        <p align="left">&nbsp;</p>
        <table width="1181" height="621" border="1" align="left" cellpadding="2">
          <tr>
            <td width="106"><div align="center">Sr No </div></td>
            <td width="355"><div align="center">Phases</div></td>
            <td width="97"><div align="center">Current Status </div></td>
            <td width="109">As on Date </td>
            <td width="152"><div align="center">Change Status</div></td>
            <td width="121"><div align="center">
              Date
            (dd-mm-yyyy)</div></td>
            <td width="181"><div align="center">Amount (Rs), if applicable </div></td>
          </tr>
          <tr>
            <td>1</td>
            <td>Receipt of Completed Application form with all Requisite Document</td>
            <td><c:out value="${user.rcpt_app_form}" /></td>
            <td><c:out value="${user.date_1}" /></td>
            <td><label>
              <div align="center">
                <select name="cmpl_app_form">
                  <option>Not Completed</option>
                  <option>Completed</option>
                </select>
              </div>
            </label></td>
            <td><label>
            <div align="center">
              <input name="date_1" type="text" id="date_1" size="12" value="<%=strDate%>">
            </div>
            </label>
            <div align="center"></div></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>2</td>
            <td>Site Inspection </td>
            <td><c:out value="${user.site_inspection}" /></td>
            <td>&nbsp;</td>
            <td><label>
              <div align="center">
                <select name="site_inspection" id="site_inspection">
                  <option>Not Completed</option>
                  <option>Completed</option>
                </select>
              </div>
            </label></td>
            <td><label>
              <div align="center">
                <input name="date_2" type="text" id="date_2" size="12" value="<%=strDate%>">
              </div>
            </label></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>3</td>
            <td>Preparartion of BOM </td>
            <td><c:out value="${user.bom_prep}" /></td>
            <td>&nbsp;</td>
            <td><label>
              <div align="center">
                <select name="bom_prep" id="bom_prep">
                  <option>Not Completed</option>
                  <option>Completed</option>
                </select>
              </div>
            </label></td>
            <td><label>
              <div align="center">
                <input name="date_3" type="text" id="date_3" size="12" value="<%=strDate%>">
              </div>
            </label></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>4</td>
            <td>Issuance of BOM </td>
            <td><c:out value="${user.BOM_ISSUANCE}" /></td>
            <td>&nbsp;</td>
            <td><label>
              <div align="center">
                <select name="bom_issuance" id="bom_issuance">
                  <option>Not Completed</option>
                  <option>Completed</option>
                </select>
              </div>
            </label></td>
            <td><label>
              <div align="center">
                <input name="date_4" type="text" id="date_4" size="12" value="<%=strDate%>">
              </div>
            </label></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>5</td>
            <td>Job Completion Certificate received ? </td>
            <td><c:out value="${user.job_cmpl_cert}" /></td>
            <td>&nbsp;</td>
            <td><label>
              <div align="center">
                <select name="job_completion" id="job_completion">
                  <option selected>NO</option>
                  <option>YES</option>
                </select>
              </div>
            </label></td>
            <td><label>
              <div align="center">
                <input name="date_5" type="text" id="date_5" size="12" value="<%=strDate%>">
              </div>
            </label></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>6</td>
            <td>Issuance of Demand rate for Supervision Charges &amp; Service Charges </td>
            <td><c:out value="${user.demand_rate}" /></td>
            <td>&nbsp;</td>
            <td><div align="center">
              <select name="demand_rate" id="demand_rate">
                <option selected>NO</option>
                <option>YES</option>
              </select>
            </div></td>
            <td><div align="center">
              <input name="date_6" type="text" id="date_6" size="12" value="<%=strDate%>">
            </div></td>
            <td><div align="center">
              <input name="demand_rate_amt" type="text" id="demand_rate_amt" size="10">
            </div></td>
          </tr>
          <tr>
            <td>7</td>
            <td>Issuance of Demand Note for Security Deposit </td>
            <td><c:out value="${user.demand_note}" /></td>
            <td>&nbsp;</td>
            <td><div align="center">
              <select name="demand_note" id="demand_note">
                <option selected>NO</option>
                <option>YES</option>
              </select>
            </div></td>
            <td><div align="center">
              <input name="date_7" type="text" id="date_7" size="12" value="<%=strDate%>">
            </div></td>
            <td><div align="center">
              <input name="demand_note_amt" type="text" id="demand_note_amt" size="10">
            </div></td>
          </tr>
          <tr>
            <td>8</td>
            <td>Receipt of Security Deposit </td>
            <td><c:out value="${user.security_deposit}" /></td>
            <td>&nbsp;</td>
            <td><div align="center">
              <select name="security_deposit" id="security_deposit">
                <option selected>NO</option>
                <option>YES</option>
              </select>
            </div></td>
            <td><div align="center">
              <input name="date_8" type="text" id="date_8" size="12" value="<%=strDate%>">
            </div></td>
            <td><div align="center">
              <input name="security_deposit_amt" type="text" id="security_deposit_amt" size="10">
            </div></td>
          </tr>
          <tr>
            <td>9</td>
            <td>Agreement</td>
            <td><c:out value="${user.agreement}" /></td>
            <td>&nbsp;</td>
            <td><div align="center">
              <select name="agreement" id="agreement">
                <option>Not Completed</option>
                <option>Completed</option>
              </select>
            </div></td>
            <td><div align="center">
              <input name="date_9" type="text" id="date_9" size="12" value="<%=strDate%>">
            </div></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>10</td>
            <td>Clearance from Electrical Inspector(For HT Consumer only) </td>
            <td><c:out value="${user.clearance_elect}" /></td>
            <td>&nbsp;</td>
            <td><div align="center">
              <select name="elect_clearance" id="elect_clearance">
                <option selected>NO</option>
                <option>YES</option>
              </select>
            </div></td>
            <td><div align="center">
              <input name="date_10" type="text" id="date_10" size="12" value="<%=strDate%>">
            </div></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>11</td>
            <td>Issuance of Work Order </td>
            <td><c:out value="${user.work_order}" /></td>
            <td>&nbsp;</td>
            <td><div align="center">
              <select name="work_order" id="work_order"> 
                <option selected>NO</option>
                <option>YES</option>
              </select>
            </div></td>
            <td><div align="center">
              <input name="date_11" type="text" id="date_11" size="12" value="<%=strDate%>">
            </div></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>12</td>
            <td>Connection</td>
            <td><c:out value="${user.connection}" /></td>
            <td>&nbsp;</td>
            <td><div align="center">
              <select name="connection" id="connection">
                <option selected>NO</option>
                <option>YES</option>
              </select>
            </div></td>
            <td><div align="center">
              <input name="date_12" type="text" id="date_12" size="12" value="<%=strDate%>">
            </div></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="85">13</td>
            <td colspan="3">Message to the Consumer, if any </td>
            <td colspan="3"><label>
              <textarea name="msg" cols="75" rows="5" ><c:out value="${user.message}" /></textarea>
            </label></td>
          </tr>
          <tr>
          </c:forEach>
            <td colspan="7"><label>
              <div align="center"> <br>
              <input type="submit" name="Submit" value="Update Status">
                <br>
            </div></label></td>
          </tr>
  </table>
  </form>
        <p align="left">&nbsp;</p>
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