<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ShowError.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="Javascript">window.history.forward(1);</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<title>Employee Portal-Login</title>

<!-- <style type="text/css">
<!--
body {
	background-color: #FFFFCC;
}
.style1 {
	font-family: "Times New Roman", Times, serif;
	font-size: 24px;
}
.style2 {color: #990000}
.style3 {
	color: #333300;
	font-size: 36px;
}
.style5 {
	color: #003399;
	font-family: "Times New Roman", Times, serif;
	font-weight: bold;
	font-size: 30px;
}
.style7 {
	color: #336699;
	font-weight: bold;
}
.style9 {color: #0000FF}
.style10 {font-size: 18px}
-->
</style> 
<script type="text/javascript">
function empFocus(){
	
	document.form1.fname.focus();
}

</script>
  <%
String p=" ";
  try{
	p= session.getAttribute("msg3").toString();
}catch(NullPointerException ex){
	p=" ";
}

%>	
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
<body onLoad="empFocus();">
<A HREF="index.jsp">HOME</A>
<div align="center" class="style1 style2">
  <p>
    <label for="imageField"></label>
    <label for="imageField"></label>
  </p>
</div>
<div class="header">
    <div id="logo" align="center">
    <table>
    <tr>
    <td><img src="${pageContext.request.contextPath}/logo.jpg"/></td>
         
    </table>
 </div>
 </div>
 </div>
<form id="form1" name="form1" method="POST" action="SearchCon" >
  <div align="center">
    <p>&nbsp;</p>
    <table width="621" height="256" border="2" bordercolor="#993300">
      <tr>
        <td height="248" bgcolor="#99CC99"><div align="center">
            <p><span class="style7">Please provide The First Name </span>Of The Applicant </p>
            <table width="430" height="94" border="1">
              <tr>
                <td width="244" bordercolor="#000000" bgcolor="#CCCC99"><p align="center" class="style9">&nbsp;</p>
                  <p align="center" class="style9">First Name of the applicant</p>
                <p class="style9">&nbsp; </p></td>
                <td width="170" bordercolor="#000000"><label>
                  <div align="center">
                    <input type="text" name="fname" id="fname" />
                    </div>
                </label></td>
              </tr>
              
              
              <tr>
                <td height="47" colspan="2" bordercolor="#000000" bgcolor="#996666"><label>
                  <div align="center">
                    <input type="submit" name="Submit" value="Search" />
                  </div>
                  <div align="center"></label>
                </div></td>
              </tr>
            </table>
            <font color="red"><%=p%></font>
        </div></td>
      </tr>
    </table>
     <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>
  </div>
</form>
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