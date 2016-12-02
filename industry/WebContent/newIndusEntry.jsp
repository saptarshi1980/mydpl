<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User Registration for Industrial Connection</title>
<style type="text/css">
<!--
.style1 {color: #800000}
.style2 {
	font-size: 18px;
	font-weight: bold;
	color: #FFFFFF;
	font-family: "Times New Roman", Times, serif;
}
-->
</style>

<script type="text/javascript">
function setFocus(){
document.getElementById("name").focus();
}
</script> 
<script type="text/javascript"> 
 
function emptyname(){ 

	if(document.form1.name.value=="")
	{
		document.form1.name.focus();
		alert("Enter Name");
		
	
	
	}
	return false;
	    
	}

</script>
<script type="text/javascript"> 
 
function validateEmail(email){
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

    if (reg.test(email.value) == false) 
    {
        alert('Invalid Email Address');
        return false;
    }

    return true;

}

</script>

 
 
</head>
<body onLoad="setFocus()">
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<form id="form1" name="form1" method="post" action="otpHandler" >
  <table width="389" border="1" align="center" cellpadding="0" bgcolor="#FF9999">
    <tr>
      <td colspan="2" bgcolor="#000000">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2"><div align="center"><span class="style1">All the fields are mandatory </span></div></td>
    </tr>
    <tr>
      <td width="400">Name:</td>
      <td width="295"><label>
        <input name="name" type="text" size="30" maxlength="50" id="name" onBlur="emptyname();" />
      </label></td>
    </tr>
    <tr>
      <td width="400">User id:</td>
      <td><label>
        <input name="uid" type="text" size="30" maxlength="50" id="uid"/>
      </label></td>
    </tr>
    <tr>
      <td width="400">E-mail id : </td>
      <td><label>
        <input name="email" type="text" size="30" maxlength="50" id="email" onBlur="validateEmail(this);"  />
      </label></td>
    </tr>
    <tr>
      <td colspan="2"><div align="center">
        <input type="submit" name="Submit" value="Generate OTP" />
      </div></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#999999"><div align="center">Please report any problem to admin@dpl.net.in </div></td>
    </tr>
  </table>
</form>
<p>&nbsp; 	</p>
</body>
</html>