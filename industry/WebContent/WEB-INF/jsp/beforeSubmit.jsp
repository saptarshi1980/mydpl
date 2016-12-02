<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="ShowError.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>General Information For New industrial Connection</title>
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
-->
</style>
<script type="text/javascript"> 
 
function message(){ 

	
		
		alert("Please Enter a Valid Mobile Number, the OTP will be sent to this number");
		
		
	    
	}

</script>
</head>
<body onLoad="document.form1.otp.focus();">
<form name="form1" method="post" action="InfoHandler">
<table width="657" height="658" border="2" align="center" cellpadding="2" bgcolor="#CCCCFF">
  <tr>
    <td colspan="4" bgcolor="#CC99CC"><div align="center" class="style1 style3">Please Check the Data Provided by You. </div></td>
  </tr>
  <tr>
    <td colspan="4" bgcolor="#CC99CC"><div align="center"><span class="style1 style3">General Information of the Industry Unit </span></div></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933">Load (KVA) Applied for </td>
    <td colspan="2" bgcolor="#999933"><label>
      <input type="text" name="load" value="<%=session.getAttribute("load")%>">
    </label></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933">Phase</td>
    <td colspan="2" bgcolor="#999933"><input type="text" name="phase" value="<%=session.getAttribute("phase")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Name of the Unit</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input name="unit_name" type="text" size="50" value="<%=session.getAttribute("unit_name")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Address of the    UNIT: Line 1</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input name="address1" type="text" size="50" value="<%=session.getAttribute("address1")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Address of the    UNIT: Line 2</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input name="address2" type="text" size="50" value="<%=session.getAttribute("address2")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933">Pin Code </td>
    <td colspan="2" bgcolor="#999933"><input name="pin_code" type="text" size="10" maxlength="6" value="<%=session.getAttribute("pinCode")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933">Landmark</td>
    <td colspan="2" bgcolor="#999933"><input name="landmark" type="text" size="50" value="<%=session.getAttribute("landmark")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933">Phone Number (Land Line) </td>
    <td colspan="2" bgcolor="#999933"><input type="text" name="landline" value="<%=session.getAttribute("landline")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
    <td height="20" width="246">Mobile</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input name="mobile" type="text" maxlength="10" value="<%=session.getAttribute("mobile")%>"></td>
  </tr>
  <%-- <tr>
    <td colspan="4" bgcolor="#CC99CC"><div align="center" class="style2">General Information of the Applicant </div></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
    <td height="20" width="246">First Name of the    Applicant</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input name="applicant_first_name" type="text" size="50" value="<%=session.getAttribute("applicantFirstName")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
    <td height="20" width="246">Last Name of the    Applicant</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input name="applicant_last_name" type="text" size="50" value="<%=session.getAttribute("applicantLastName")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Applicant's Address    Line 1</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input name="applicant_address1" type="text" size="50" value="<%=session.getAttribute("applicantAddress1")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Applicant's Address    Line 2</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input name="applicant_address2" type="text" size="50" value="<%=session.getAttribute("applicantAddress2")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933">Pin Code </td>
    <td colspan="2" bgcolor="#999933"><input type="text" name="applicant_pincode" value="<%=session.getAttribute("applicantPinCode")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933"><table cellspacing="0" cellpadding="0">
    <td height="20" width="271">Applicant's Contact    Number (Land Line)</td>
    </table></td>
    <td colspan="2" bgcolor="#999933"><input type="text" name="applicant_landline" value="<%=session.getAttribute("applicantLandLine")%>"></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#999933">Applicant's Contact    Number (Mobile)-<span class="style4">One Time Password will be sent to this number </span></td>
    <td colspan="2" bgcolor="#999933"><input name="applicant_mobile" type="text" maxlength="10" value="<%=session.getAttribute("applicantMobile")%>"></td>
  </tr>
  <tr>
    <td colspan="4" bordercolor="#F0F0F0" bgcolor="#CC99CC"><div align="center" class="style2">Referee Details </div></td>
  </tr>
  <tr>
 --%>    <td colspan="2" bgcolor="#999933"><div align="center">Referee 1</div></td>
    <td colspan="2" bgcolor="#999933"><div align="center">Referee 2 </div></td>
  </tr>
  <tr>
    <td width="57" height="31" bgcolor="#999933">Name</td>
    <td width="268" bgcolor="#999933"><input name="referee1_name" type="text" size="40" value="<%=session.getAttribute("referee1")%>"></td>
    <td width="51" bgcolor="#999933">Name</td>
    <td width="243" bgcolor="#999933"><input name="referee2_name" type="text" size="40" value="<%=session.getAttribute("referee2")%>"></td>
  </tr>
  <tr>
    <td height="25" bgcolor="#999933">Address</td>
    <td height="25" bgcolor="#999933"><input name="referee1_address" type="text" size="40" value="<%=session.getAttribute("referee1Adderess")%>"></td>
    <td bgcolor="#999933">Address</td>
    <td bgcolor="#999933"><input name="referee2_address" type="text" size="40" value="<%=session.getAttribute("referee2Adderess")%>"></td>
  </tr>
  
  <!-- <tr>
    <td height="5" colspan="3" bgcolor="#99831D"><div align="left">Enter The One Time Password Which you Have Received </div></td>
    <td height="5" bgcolor="#99831D"><label>
      <input type="text" name="otp">
    </label></td>
  </tr> -->
  <tr>
    <td height="5" colspan="4" bgcolor="#993300"><div align="center">
      <input type="submit" name="Submit" value="Submit">
    </div></td>
  </tr>
</table>
</form>
</body>
</html>