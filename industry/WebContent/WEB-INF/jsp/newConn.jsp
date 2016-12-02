<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="ShowError.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>General Information For New industrial Connection</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<style type="text/css">
<!--
.style1 {
	color: #0000CC;
	font-weight: bold;
}
.style2 {
	color: #000066;
	font-weight: bold;
}
.style3 {color: #000033}
.style4 {
	color: #330033;
	font-weight: bold;
	font-style: italic;
}
.style5 {
	color: #3333FF;
	font-weight: bold;
}
-->
</style>
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
<script type="text/javascript"> 
 
function message(){ 

	
		
		alert("Please Enter a Valid Mobile Number, the OTP will be sent to this number");
		
		
	    
	}

</script>
<script type="text/javascript">
function validateForm()
{
var x=document.forms["form1"]["load"].value;

if (x==null || x=="")
  {
  alert("Fields must be entered properly");
  return false;
  }
  
var phase=document.forms["form1"]["phase"].value;

if (phase==null || phase=="")
  {
  alert("Fields must be entered properly");
  return false;
  }
  
var unit_name=document.forms["form1"]["unit_name"].value;

if (unit_name==null || unit_name=="")
  {
  alert("Fields must be entered properly");
  return false;
  }
var address1=document.forms["form1"]["address1"].value;  
if (address1==null || address1=="")
{
alert("Fields must be entered properly");
return false;
}

var address2=document.forms["form1"]["address2"].value;  
if (address2==null || address2=="")
{
alert("Fields must be entered properly");
return false;
}

var pin_code=document.forms["form1"]["pin_code"].value;  
if (pin_code==null || pin_code=="")
{
alert("Fields must be entered properly");
return false;
}

var landmark=document.forms["form1"]["landmark"].value;  
if (landmark==null || landmark=="")
{
alert("Fields must be entered properly");
return false;
}
  
var mobile=document.forms["form1"]["mobile"].value;  
if (mobile==null || mobile=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_first_name=document.forms["form1"]["applicant_first_name"].value;  
if (applicant_first_name==null || applicant_first_name=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_last_name=document.forms["form1"]["applicant_last_name"].value;  
if (applicant_last_name==null || applicant_last_name=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_address1=document.forms["form1"]["applicant_address1"].value;  
if (applicant_address1==null || applicant_address1=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_address2=document.forms["form1"]["applicant_address2"].value;  
if (applicant_address2==null || applicant_address2=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_pincode=document.forms["form1"]["applicant_pincode"].value;  
if (applicant_pincode==null || applicant_pincode=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_mobile=document.forms["form1"]["applicant_mobile"].value;  
if (applicant_mobile==null || applicant_mobile=="")
{
alert("Fields must be entered properly");
return false;
}

var referee1_name=document.forms["form1"]["referee1_name"].value;  
if (referee1_name==null || referee1_name=="")
{
alert("Fields must be entered properly");
return false;
}

var referee2_name=document.forms["form1"]["referee2_name"].value;  
if (referee2_name==null || referee2_name=="")
{
alert("Fields must be entered properly");
return false;
}


var referee1_address=document.forms["form1"]["referee1_address"].value;  
if (referee1_address==null || referee1_address=="")
{
alert("Fields must be entered properly");
return false;
}

var referee2_address=document.forms["form1"]["referee2_address"].value;  
if (referee2_address==null || referee2_address=="")
{
alert("Fields must be entered properly");
return false;
}



}
</SCRIPT>
<script type="text/javascript">
function validateLoad()
{
   if(isNaN(form1.load.value))
  { 
      alert("A Numerical value must be entered ");
      form1.load.value="";
      form1.load.focus();
      return false;
  } 

}

function validatePhase()
{
   if(isNaN(form1.phase.value))
  { 
      alert("A Numerical value must be entered ");
      form1.phase.value="";
      form1.phase.focus();
      return false;
  } 

}

function validatePin()
{
   if(isNaN(form1.pin_code.value))
  { 
      alert("A Numerical value must be entered ");
      form1.pin_code.value="";
      form1.pin_code.focus();
      return false;
  } 

}

function validateLand()
{
   if(isNaN(form1.landline.value))
  { 
      alert("A Numerical value must be entered ");
      form1.landline.value="";
      form1.landline.focus();
      return false;
  } 

}

function validateMobile()
{
   if(isNaN(form1.mobile.value))
  { 
      alert("A Numerical value must be entered ");
      form1.mobile.value="";
      form1.mobile.focus();
      return false;
  } 

}

function applicantPin()
{
   if(isNaN(form1.applicant_pincode.value))
  { 
      alert("A Numerical value must be entered ");
      form1.applicant_pincode.value="";
      form1.applicant_pincode.focus();
      return false;
  } 

}

function applicantLand()
{
   if(isNaN(form1.applicant_landline.value))
  { 
      alert("A Numerical value must be entered ");
      form1.applicant_landline.value="";
      form1.applicant_landline.focus();
      return false;
  } 

}

</script>
</head>
<body onLoad="document.form1.load.focus();" bgcolor="#FFF8DC">

<A HREF="index.jsp">HOME</A> 
<form name="form1" method="post" action="StoreConnectionInfo" onSubmit="return validateForm()">
<table width="657" height="564" border="1" align="center" cellpadding="2" bgcolor="#CCCCFF">
  <tr>
    <td colspan="4" bgcolor="#CC99CC"><blink>
      <div align="center" class="style5">ALL FIELDS ARE MANDATORY. </div>
    </blink></td>
  </tr>
  <tr>
    <td colspan="4" bgcolor="#CC99CC"><div align="center"><span class="style1 style3">General Information of the Industry Unit </span></div></td>
  </tr>
  <tr>
    <td colspan="4" bgcolor="#CC99CC"><div align="center" class="style1 style3">User Id- </div></td>
  </tr>
  <tr>
    <td height="28" colspan="2">Load (KVA) Applied for </td>
    <td colspan="2"><label>
      <input type="text" name="load" id="load" onBlur="return validateLoad()">
    </label></td>
  </tr>
  <tr>
    <td height="28" colspan="2">Phase</td>
    <td colspan="2"><input type="text" name="phase" onBlur="return validatePhase()"></td>
  </tr>
  <tr>
    <td height="28" colspan="2"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Name of the Unit</td>
    </table></td>
    <td colspan="2"><input name="unit_name" type="text" size="50"></td>
  </tr>
  <tr>
    <td height="28" colspan="2"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Address of the    UNIT: Line 1</td>
    </table></td>
    <td colspan="2"><input name="address1" type="text" size="50"></td>
  </tr>
  <tr>
    <td height="28" colspan="2"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Address of the    UNIT: Line 1</td>
    </table></td>
    <td colspan="2"><input name="address2" type="text" size="50"></td>
  </tr>
  <tr>
    <td height="28" colspan="2">Pin Code </td>
    <td colspan="2"><input name="pin_code" type="text" size="10" maxlength="6" onBlur="return validatePin()"></td>
  </tr>
  <tr>
    <td height="28" colspan="2">Landmark</td>
    <td colspan="2"><input name="landmark" type="text" size="50"></td>
  </tr>
  <tr>
    <td height="28" colspan="2">Phone Number (Land Line) </td>
    <td colspan="2"><input type="text" name="landline" onBlur="return validateLand()"></td>
  </tr>
  <tr>
    <td height="28" colspan="2"><table cellspacing="0" cellpadding="0">
    <td height="20" width="246">Mobile</td>
    </table></td>
    <td colspan="2"><input name="mobile" type="text" maxlength="10" onBlur="return validateMobile()"></td>
  </tr>
  
  <tr>
    <td colspan="4" bordercolor="#F0F0F0" bgcolor="#CC99CC"><div align="center" class="style2">Referee Details </div></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">Referee 1</div></td>
    <td colspan="2"><div align="center">Referee 2 </div></td>
  </tr>
  <tr>
    <td width="51" height="31">Name</td>
    <td width="252"><input name="referee1_name" type="text" size="40"></td>
    <td width="51">Name</td>
    <td width="250"><input name="referee2_name" type="text" size="40"></td>
  </tr>
  <tr>
    <td height="25">Address</td>
    <td height="25"><input name="referee1_address" type="text" size="40"></td>
    <td>Address</td>
    <td><input name="referee2_address" type="text" size="40"></td>
  </tr>
  
  <tr>
    <td height="12" colspan="4" bgcolor="#993300"><div align="center">
      <input type="submit" name="Submit" value="Submit">
    </div></td>
  </tr>
</table>
</form>
<div class="footer">
<table align="center">
<tr><td><div align="center" class="style1">Portal Developed and Maintained by IT Cell, The Durgapur Projects Limited.</div></td>
</tr>
<tr><td><div align="center" class="style1">In case of any issue, please write to admin@dpl.net.in</div></td>
</tr>
</div>
</body>
</html>