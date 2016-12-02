<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>The Durgapur Projects Limited</title>
<meta name="keywords" content="DPL" />
<meta name="description" content="DPL" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen, print, projection">
<link rel="stylesheet" type="text/css" href="styles.css" >
<style type="text/css">
<!--
.style3 {font-size: medium}
.style4 {
	font-size: medium;
	color: #663366;
	font-weight: bold;
}
.style5 {
	color: #663366;
	font-weight: bold;
}
-->
</style>


</head>
<body>

<div id="templatemo_container_wrapper">
	<div class="templatemo_spacer"></div>
<div id="templatemo_container">
<!-- <div id="templatemo_top"> <a href="http://www.templatemo.com" target="_parent">Website Templates</a> · <a href="http://www.flashmo.com/" target="_parent">Flash Templates</a> · <a href="#">Company</a> · <a href="#">Contact</a></div> -->
  <div id="templatemo_header">
      <div id="inner_header"><br><br>
        <img src="images/logo_blue.jpg" alt="" width="325" height="65">
      </div>
  </div>
  
  <div align="center">

  
	
</div>	
	
<br><br>
	
  
      <div id="templatemo_left_column">
        <form name="frm1" action="Inter.dpl" method="post" onSubmit="validateForm()">

<input type="hidden" value="${sessionScope.msg}" name="msg"/>
<br>
<br><br>
<div align="center"><h3>Please Do Not Press refresh/Stop Button During The Entire Process</h3><br></div>
<div align="center"><h3>Please select the Bill Month for which you want to make the Payment</h3><br></div>


<table width="471" border="1" align="center" cellpadding="1" cellspacing="2">
<tr><th width="145" bgcolor="#996633">Bill Month</th>
   <th width="124" bgcolor="#996633">Bill Amount</th>
   <th width="148" bgcolor="#996633">Due Date</th>
   </tr>
<c:forEach items="${al}" var="bill_info">
   
   
   <tr>
       <td bgcolor="#FFFFFF"><input type="radio" NAME="a" value=${bill_info.billMonthWord} ><c:out value="${bill_info.billMonthWord}"></c:out></td>
       <td bgcolor="#FFFFFF"><div align="center">Rs. ${bill_info.billAmt}</div></td>
       <td bgcolor="#FFFFFF"><div align="center">${bill_info.dueDate}</div></td>
       <input type="hidden" name="con_no" value="${bill_info.partyCode}"/>
       <input type="hidden" name="bill_amt" value="${bill_info.billAmt}"/>
	   <input type="hidden" name="bill_month" value="${bill_info.billMonth}"/>
    </tr>
</c:forEach>


</table>

<br>&nbsp;
<table width="325" border="1" align="center" cellpadding="2">
  <tr>
    <td colspan="2" bgcolor="#996633"><div align="center">Select The Payment Mode </div></td>
  </tr>
  <tr>
    <td width="145" bgcolor="#FFFFFF"><label>
      <input name="b" type="radio" value="radiobutton" checked>
      Internet Banking</label></td>
    <td width="160">Powered by BillDesk </td>
  </tr>
</table>
<div align="center"></div>
<p>&nbsp;</p>
<p><br>
</p>
<div align="center">
<input type="image" name="button1" src="button.png" alt="Submit" >
</div>
</form>
        
      </div>
    
    	<div id="templatemo_right_column">
           
            <ul class="templatemo_menu">
              <li><a href="index.dpl">Homepage</a></li>
              <li><a href="#" target="_parent">Link</a></li>
              <li><a href="#">Link</a></li>
              <li><a href="#">Link</a></li>
              <li><a href="#">Link</a></li>
              <li><a href="#" target="_parent">Link</a></li>
          </ul>
          
          <div class="section_box" align="justify">
            <div class="subtitle">Quick Contact</div>
              Tel: 0343-2553639<br />
              Fax: 0343-2553639<br />
              Email: admin[at]dpl.net.in<br />
              <br />
          </div>
          <div class="section_box" align="justify">
          <div class="subtitle">About this website</div>
            This Website has been developed by IT Cell, The Durgapur Projects Ltd<br />
            <a href="http://validator.w3.org/check?uri=referer"><img  src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a> 
          </div>
          
          <div class="section_box">
            <div class="subtitle">Sectional Heading</div>
              <a href="#">Link</a><br />
              <a href="#">Link</a><br />
              <a href="#">Link</a><br />
              <a href="#">Link</a><br />
              <a href="#" target="_parent">Link</a><br />
          </div>
    </div>

	<div id="templatemo_footer">
    Copyright 2015. Site Developed & Maintained by IT Cell, The Durgapur Projects Limited.    </div>
        
</div>
<div class="templatemo_spacer"></div>
</div>
</body>
</html>