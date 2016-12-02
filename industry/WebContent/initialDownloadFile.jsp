<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<%@ page import="domain.HostName" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <%-- <%@ page errorPage="ShowError.jsp" %> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DPL-Load Dispatch</title>
<style>
div.header {
    background-color:#5882FA;
    color:white;
    margin:20px;
    padding:20px;
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
.style2 {
	color: #000000;
	font-weight: bold;
}
  </style>
</head>
<body>

<div class="header">
    <div id="logo" align="center">
    <table>
    <tr>
    <td><img src="logo.jpg" /></td>
         
    </table>
 </div>
</div>
 </div>
<a href='index.jsp'><span>Home</span></a><br>
<%

//String host= new HostName().getHostName().toString();
%>
<jsp:useBean id="host" class="domain.HostName" />
<c:set var = "hostname" value = "${host.hostName}" scope = "session" />
                     

<BR><BR>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://192.168.30.7:3306/dplsw"
        user="remote" password="dgppro1961"
    />
    
    <%-- <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/dplsw"
        user="root" password="dpl123"
    /> --%>
    
    <%
        String date = request.getAttribute("date").toString().trim();
    %> 
     
     
    <sql:query var="listUsers"   dataSource="${myDS}">
       
        SELECT DATE_FORMAT(upload_date,'%d-%m-%Y') AS upload_date,head,file_path,"Download File" AS FILE,DATE_FORMAT(date_time,'%d-%m-%Y %H:%i:%s') AS date_time FROM upload_master WHERE DATE_FORMAT(upload_date,'%d-%m-%Y')='<%= date%>' and head='INITIAL' ORDER BY date_time desc
    
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <h2>List of Initial Load Dispatch Files Uploaded By DPL on <%= date%> </h2>
            <tr>
                <th>File</th>
                <th>Upload date & time </th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><a href="ShowFile?file=${user.file_path}"><c:out value="${user.FILE}" /></a></td>
                    <td><c:out value="${user.date_time}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
    
    <br>
    <br>
     <div class="footer">
<table align="center">
<tr><td><div align="center" class="style1">Portal Developed and Maintained by IT Cell, The Durgapur Projects Limited.</div></td>
</tr>
<tr><td><div align="center" class="style1">In case of any issue, please write to admin@dpl.net.in</div></td>
</tr>
</table>

</div>
    
</body>
</html>