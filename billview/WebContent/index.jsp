<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electricity Bill </title>
<style type="text/css">
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
	font-size: 18px;
	font-weight: bold;
}
.style4 {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-weight: bold;
}
-->
</style>

</head>




<div align="center" class="style1 style2">
  <p>
    <label for="imageField"></label>
    <label for="imageField"></label>
    <input type="image" name="imageField" src="imgs/DPL Color Logo actual.jpg" id="imageField" />
  </p>
  <p class="style4">Bill Generation</p>
</div>

<form id="form1" name="form1" action="verifycon"  method="POST" >
  <div align="center">
    <p>&nbsp;</p>
    <p class="style3">Enter Your Consumer Number </p>
    <table width="621" height="193" border="2" bordercolor="#993300">
      <tr>
        <td height="185"><div align="center">
            <table width="272" height="94" border="1">
             
              <tr>
                <td>Consumer Number</td>
                <td><label>
                  <input type="text" name="conNo" id="conNo"/>
                </label></td>
              </tr>
              
              <tr>
                <td height="47" colspan="2" bgcolor="#996666"><label>
                  <div align="center">
                  <input type="submit" name="Submit" value="Proceed" />
                </div>
                </label></td>
              </tr>
            </table>
            
        </div></td>
      </tr>
    </table>
     <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>
  </div>
</form>
</body>
</html>