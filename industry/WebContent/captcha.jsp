<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Captcha</title>
<link href="style.css" type="text/css" rel="stylesheet" />
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
<body onLoad="document.myform.answer.focus();" >

<a href='index.jsp'><span>HOME</span></a>
<center>
 <div class="header">
    <div id="logo" align="center">
    <table>
    <tr>
    <td><img src="logo.jpg" /></td>
         
    </table>
 </div>
 
 </div>
 <br><br> <br><br>
<h3>Please Enter The Code As Shown Below To Proceed </h3>
<form name="myform" action="captchasubmit.jsp" method="post">
<table width="353" border="1" cellspacing="1">
<tr> <td width="209"><div align="right"><img id="captcha" src="<c:url value="simpleCaptcha.jpg"  />" ></div></td>
<td width="150"><a href="captcha.jsp">Show Another Image </a></td>
</tr>
<tr><td colspan="2"><div align="center">
  <input type="text" name="answer" />
</div></td></tr>
<tr><td colspan="2"><div align="center">
  <input type="submit" value="Submit">
</div></td></tr>
</table>

<br>
</form>
</center>
<br><br><br><p>
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
