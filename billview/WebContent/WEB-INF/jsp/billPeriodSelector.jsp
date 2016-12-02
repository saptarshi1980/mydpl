<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <script language="Javascript">window.history.forward(1);</script> -->
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Month Selection</title>
<style type="text/css">
<!--
body,td,th {
	font-family: Times New Roman, Times, serif;
}
.style7 {color: #0066FF; font-weight: bold; font-size: 18px; }
.style8 {
	color: #0000FF;
	font-weight: bold;
	font-size: 24px;
}
body {
	background-color: #FFFFCC;
}
.style9 {
	color: #330000;
	font-weight: bold;
}
-->
</style>
<!-- <script language="javascript">
document.onmousedown=disableclick;
status="Right Click Disabled";
Function disableclick(event)
{
  if(event.button==2)
   {
     alert(status);
     return false;    
   }
}
</script> -->
</style>

</head>
<body>

<%
			String imageUrl = request.getContextPath()+"/imgs/DPL Color Logo actual.jpg";
%>
<table width="1068" height="98" border="0" align="center">
  <tr>
    <td width="187" rowspan="2"><div align="center"><img src="<%=imageUrl%>" alt="logo" width="82" height="75" align="top" /></div></td>
    <td width="681" rowspan="2" valign="top"><div align="center"><span class="style8">THE DURGAPUR PROJECTS LIMITED</span><br />
        <span class="style7">(A Government of West Bengal Enterprise)<br />
         Administrative Building, Durgapur- 713201<br />
    CIN: U40102WB1961SGC025250</span></div></td>
    <td width="186" height="94" align="center" valign="top"><p></p>
    <p><a href="index.jsp">HOME</a></p>
   
    <p>&nbsp;</p></td>
   
	
  </tr>
</table>

<%
String conNo=request.getSession().getAttribute("conNo").toString();
request.getSession().setAttribute("conNo", conNo);
%>
<div align="center">
  <table width="364" height="262" border="1" bordercolor="#990066">
    <tr>
      <td height="41" bordercolor="#996633" bgcolor="#CCCC66"><div align="center"><span class="style9">Please select Bill Period</span> </div></td>
    </tr>
    <tr>
      <td width="354" height="213" bordercolor="#996633" bgcolor="#CCCC99"><form name="form1" method="get" action="Generate">
        <p align="center"><strong>Bill Period Selection </strong>
          <select id="billmonth" name="billmonth">
            <c:forEach items="${billMonth}" var="billMonth">
              <option value="${billMonth}"> ${billMonth} </option>
            </c:forEach>
            
          </select>
         
           
          <br>
          <br>
          <br><label>
            <input type="submit" name="Submit" value="Generate Bill">
            </label>
          <br>
          <br>
          <br>
          
          
           
        </form>      </td>
    </tr>
  </table>
</div>
<p align="center">&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>