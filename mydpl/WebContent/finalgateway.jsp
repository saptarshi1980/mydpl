<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
    function submit()
    {
        
        document.frm1.submit(); // Submits the form without the button
    }
</script>
</head>
<body onload="submit()">
<form name="frm1" action="https://pgi.billdesk.com/pgidsk/PGIMerchantPayment" method="POST">

<input type="hidden" value="${requestScope.msg}" name="msg"/>
<br>
<br><br>

<h2>A Payment request has been initiated by you and you are being redirected to Bill Desk URL</h2><br>
<h3>Please Do Not Press refresh/Stop Button During The Entire Process</h3><br><br>


</form>
 
</body>
</html>