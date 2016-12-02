<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%-- <%@ page errorPage="ShowError.jsp" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Submission Successful</title>
<style type="text/css">
<!--
.style1 {color: #993366}
-->
</style>
</head>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<%
        String conNumber = request.getSession().getAttribute("custNo").toString().trim();
        session.setAttribute("temp_con_no", conNumber);
      
%>
<table width="709" height="35" border="1" align="center" cellpadding="2">
  <tr>
    <td width="480" nowrap>Data Submission Successful!! Please Note your Temporary Customer No-</td>
    <td width="209" nowrap bgcolor="#CCCCCC"><span class="style1"><%=conNumber%></span></td>
  </tr>
  <tr>
    <td colspan="2" nowrap><div align="center"><A HREF="AppRcpt">Click Here To Generate Your Application receipt</A></div></td>
  </tr>
  <tr>
    <td colspan="2" nowrap><div align="center"><A HREF="annex.pdf" target="_blank">List of Documents To Be Submitted</A></div></td>
  </tr>
  <tr>
    <td colspan="2" nowrap><div align="center"><A HREF="ANNEXURE_A.pdf" target="_blank">Annexure A</A></div></td>
  </tr>
  <tr>
    <td colspan="2" nowrap><div align="center"><A HREF="Guidline.pdf" target="_blank">Guideline</A></div></td>
  </tr>
  <tr>
    <td colspan="2" nowrap><div align="center"><A HREF="index.jsp">HOME</A></div></td>
  </tr>
</table>


<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>