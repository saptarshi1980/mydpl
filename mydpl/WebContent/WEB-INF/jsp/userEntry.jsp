<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User Registration User Portal</title>
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
 
function emptycon(){ 

	if(document.form1.con_no.value=="")
	{
		document.form1.con_no.focus();
		alert("Enter Consumer Number");
		
	
	
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
<form id="form1" name="form1" method="post" action="ValidateConsumerRegister.dpl" >
  <table width="389" border="1" align="center" cellpadding="0" bgcolor="#FF9999">
    <tr>
      <td colspan="2" bgcolor="#000000">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#CC99CC"><div align="center"><span>All the fields are mandatory </span></div></td>
    </tr>
    <tr>
      <td width="400">Consumer Number:</td>
      <td width="295"><label>
        <input name="con_no" type="text" size="30" maxlength="50" id="con_no" onBlur="emptycon();" />
      </label></td>
    </tr>
    <tr>
      <td width="400">Meter No:</td>
      <td><label>
        <input name="meter_no" type="text" size="30" maxlength="50" id="meter_no"/>
      </label></td>
    </tr>
    <tr>
      <td width="400">Name: </td>
      <td><label>
        <input name="name" type="text" size="30" maxlength="50" id="name"  />
      </label></td>
    </tr>
    
    <tr>
      <td width="400">Address: </td>
      <td><label>
        <input name="address" type="text" size="30" maxlength="50" id="address"  />
      </label></td>
    </tr>
    
    
    <tr>
      <td width="400">Mobile : </td>
      <td><label>
        <input name="mobile" type="text" size="30" maxlength="50" id="mobile"  />
      </label></td>
    </tr>
    
    
    
    
    <tr>
      <td width="400">E-mail id : </td>
      <td><label>
        <input name="email" type="text" size="30" maxlength="50" id="email" onBlur="validateEmail(this);"  />
      </label></td>
    </tr>
    <tr>
      <td width="400">Password : </td>
      <td><label>
        <input name="password" type="password" size="30" maxlength="50" id="password"  />
      </label></td>
    </tr>
    
    <tr>
      <td width="400">Re-Type Password : </td>
      <td><label>
        <input name="password2" type="password" size="30" maxlength="50" id="password2"  />
      </label></td>
    </tr>
    
    <tr>
      <td width="400">Mother's Maiden Name (This will be used in case you forget your password): </td>
      <td><label>
        <input name="mother_name" type="text" size="30" maxlength="50" id="mother_name"  />
      </label></td>
    </tr>
    
    
    <tr>
      <td colspan="2"><div align="center">
        <input type="submit" name="Submit" value="Continue" />
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