<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script type="text/javascript">
function pwdFocus(){
	
	document.form1.pwd1.focus();
}

</script>
<script type="text/javascript">
function validateForm()
{
var x=document.forms["form1"]["pwd1"].value;

if (x==null || x=="")
  {
  alert("Fields must be entered properly");
  return false;
  }
  
var y=document.forms["form1"]["pwd2"].value;

if (y==null || y=="")
  {
  alert("Fields must be entered properly");
  return false;
  }

if(x!=y)
 {
 
	alert("Passwords must be same");
	  return false;
 }


}

</SCRIPT>


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
<body onLoad="pwdFocus();">
<A HREF="index.jsp">HOME</A>
<div class="header">
    <div id="logo" align="center">
    <table>
    <tr>
    <td><img src="${pageContext.request.contextPath}/logo.jpg"/></td>
         
    </table>
 </div>
<p><br><br>

<form action="ChangePassword" method="POST" name="form1" onSubmit="return validateForm()">
  <table width="621" height="256" border="2" align="center" bordercolor="#993300">
    <tr>
      <td height="248" bgcolor="#99CC99"><div align="center">
          <p><strong><span class="style10"> Change Password </span>
          </strong>
        <table width="345" height="118" border="1">
            <tr>
              <td width="146" bordercolor="#000000" bgcolor="#CCCC99"><span class="style9">Password</span></td>
              <td width="225" bordercolor="#000000"><label>
                <input type="password" name="pwd1" id="uid" />
              </label></td>
            </tr>
            <tr>
              <td bordercolor="#000000" bgcolor="#CCCC99"><span class="style9">Re-Enter Password </span></td>
              <td bordercolor="#000000"><label>
                <input type="password" name="pwd2" id="pass"/>
              </label></td>
            </tr>
            <tr>
              <td colspan="2" bordercolor="#000000" bgcolor="#996666"><label>
                <div align="center">
                  <input type="submit" name="Submit" value="Change Password" />
                  </label>
              </div></td>
            </tr>
          </table>
        
    </tr>
  </table>

</form>


<br><br>


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