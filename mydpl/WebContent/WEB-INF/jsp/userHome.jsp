<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>The Durgapur Projects Limited-User Home</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

</head>
<body ><br>
<div align="center"><img src="<%= application.getRealPath("images/logo_blue.jpg") %>" /></div><br>
  
  <section class="container">
      <div class="login">
      <h1>Welcome </h1>
      
        <a href="PayBillRegisteredUser.dpl">Pay Outstanding Bill</a><br><br>
        <a href="ViewPaymentReceipt.dpl">View Payment Receipts of earlier online payments</a> 
      
    </div><p>
    <div align="center"><br>
    <p><a href="Logout.dpl">Logout</a></p>
    <p><a href="ChangePassword.dpl">Change Password</a></p>
    </div>
    
  </section>

  <section class="about">
     <p class="about-author">
     Site Developed by IT Cell, The Durgapur Projects Limited.
  </section>
</body>
</html>
