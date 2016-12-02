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
<style>
div.header {
    background-color:#5882FA;
    color:white;
    margin:10px;
    padding:5px;
    height:90px;
} 

div.footer {
    background-color:#5882FA;
    color:white;
    margin:20px;
    padding:20px;
} 
.style1 {
	font-size: medium;
	font-weight: bold;
}
</style>
</head>
<body>


<a href='index.jsp'><span>Home</span></a><br>
<div class="header">
    <div id="logo" align="center">
    <table>
    <tr>
    <td><img src="${pageContext.request.contextPath}/logo.jpg"/></td>
         
    </table>
 </div>
 </div>
 </div>


<BR><BR>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://192.168.30.7:3306/dplsw"
        user="remote" password="dgppro1961"
    />
    
    <%
        String fName = request.getSession().getAttribute("fName").toString().trim();
    %>
     
    <sql:query var="listUsers"   dataSource="${myDS}">
       
        SELECT temp_con_no,conn_load,conn_phase,unit_name,applicant_fname,applicant_lname,entry_date FROM new_consumer where applicant_fname LIKE '<%= fName%>' order by entry_date
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Please Note Down The Temporary Consumer Number Pertaining To You.</h2></caption>
            <tr>
                <th>Temp Connection No</th>
                <th>Load</th>
                <th>Phase</th>
                <th>Name of the Unit</th>
                <th>Applicant First Name</th>
                <th>Applicant Surname</th>
                <th>Entry Date and Time</th>
           </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.temp_con_no}" /></td>
                    <td><c:out value="${user.conn_load}" /></td>
                    <td><c:out value="${user.conn_phase}" /></td>
                    <td><c:out value="${user.unit_name}" /></td>
                    
                              
                    <td><c:out value="${user.applicant_fname}" /></td>
                    <td><c:out value="${user.applicant_lname}" /></td>
                    
                    
                    
                    <td><c:out value="${user.entry_date}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br><br><br><br>
    <div class="footer">
<table align="center">
<tr><td><div align="center" class="style1">Portal Developed and Maintained by IT Cell, The Durgapur Projects Limited.</div></td>
</tr>
<tr><td><div align="center" class="style1">In case of any issue, please write to admin@dpl.net.in</div></td>
</tr>
</table>
</body>
</html>