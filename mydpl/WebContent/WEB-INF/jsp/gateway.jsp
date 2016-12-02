<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="frm1" action="http://localhost:8080/billdesk/ReceiveServlet" method="POST">

<input type="hidden" value="${sessionScope.msg}" name="msg"/>
<br>
<br><br>

<h2>A Payment request has been initiated by you and you are being redirected to Bill Desk URL</h2><br><br>

<input type="Submit" value="Yes, Proceed">
</form>

</body>
</html>