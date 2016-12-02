<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<html>
<head>
<title>The Durgapur Projects Limited</title>

    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link href="js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="js-image-slider.js" type="text/javascript"></script>
    <link href="generic.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="styles.css">
   	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   	<script src="script.js"></script>
   	<script
    src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false">
    </script>
  <meta charset="utf-8">
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
    <style>
div.header {
    background-color:#5882FA;
    color:white;
    margin:20px;
    padding:20px;
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
.style2 {
	color: #000000;
	font-weight: bold;
}
  </style>
        <title>MIS UPLOAD HISTORY</title>
    </head>
 
    <body> 
    <div class="header">
    <div id="logo" align="center">
    <table>
    <tr>
    <td><img src="logo.jpg" /></td>
         
    </table>
 </div>
</div>
 </div>
        <div id="result" align="center" >
            <h3>${requestScope["msg"]}</h3>
            <br>
            <a href="Home"><span>Home</span></a>
        </div>
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
