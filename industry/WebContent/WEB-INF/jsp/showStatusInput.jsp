<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ShowError.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DPL New Industrial Consumer-Enter Your Temporary Consumer Number</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
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
<body onLoad="document.form1.con_no.focus();" bgcolor="#FFF8DC">
<form name="form1" action="ShowStatus" method="post">
<div class="header">
    <div id="logo" align="center">
    <table>
    <tr>
    <td><img src="${pageContext.request.contextPath}/logo.jpg"/></td>
         
    </table>
 </div>

<br><br><br>
<a href='index.jsp'><span>Home</span></a>
<BR>
<BR>
<a href="ForgotConNo"><span>Forgot Temporary Consumer Number</span></a>
<BR>
<BR>
<BR>
<BR>
Temporary Consumer Number
<table width="200" border="1" align="center" cellpadding="2">
  <tr>
    <td width="214" bgcolor="brown">Temporary Consumer Number </td>
    <td width="189"><label>
      <input name="con_no" type="text" id="con_no">
    </label></td>
  </tr>
  <tr>
    <td colspan="2"><label>
      <div align="center">
        <input type="submit" name="Submit2" value="Get status">
      </div>
      </label></td>
    </tr>
</table>



</form>


</body>
</html>