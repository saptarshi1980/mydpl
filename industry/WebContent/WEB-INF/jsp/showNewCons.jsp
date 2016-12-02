<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DPL-New Consumers Details</title>
</head>
<body>

<a href='index.jsp'><span>Home</span></a><br>
<a href="PassordHandler"><span>Change Password</span></a>

<BR><BR>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://192.168.30.7:3306/dplsw"
        user="remote" password="dgppro1961"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
       
        SELECT temp_con_no,conn_load,conn_phase,unit_name,unit_address1,unit_address2,unit_pincode,unit_landmark,unit_landline,unit_mobile,applicant_fname,applicant_lname,applicant_address1,applicant_address2,applicant_pincode,applicant_landline,applicant_mobile,name_ref1,address_ref1,name_ref2,address_ref2,entry_date FROM new_consumer order by entry_date
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of New Consumers</h2></caption>
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
                    <td><a href="ShowConsDetail?con=${user.temp_con_no}"><c:out value="${user.temp_con_no}" /></a></td>
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
            </c:forEach>
        </table>
    </div>
</body>
</html>