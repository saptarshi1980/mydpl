<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
function validateForm()
{
	if (!(document.frm1.mobile.value.length==10)) {
            alert("Please enter a 10 digit  number.");
            return false;
        }
   else if(isNaN(document.frm1.mobile.value))
   { 
	      alert("A Numerical value must be entered ");
	      document.frm1.mobile.value="";
	      return false;
	  } 


}
</SCRIPT>
<script type = "text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type = "text/javascript">
    function ValidateEmail(email) {
        var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        return expr.test(email);
    };
    $("#commit").live("click", function () {
        
    	if(document.frm1.email.value.length>0)
    	
    	{
    		if (!ValidateEmail($("#email").val())) {
    	
            alert("Invalid email address.");
            return false;
        }
        else {
            
            return true;
        }
    	
    	}
    	
    });
    $('frm1').submit(function() {
    	  return false;
    	});
</script>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Submit Information</title>
  <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Welcome, <c:out value="${requestScope.name}"></c:out>(<c:out value="${requestScope.party_code}"></c:out>)</h1>
      <h1>Provide Mobile No & E-Mail id</h1>
      <form method="post" action="UpdateInfo" NAME="frm1" onsubmit="return validateForm()">
        <p><input type="text" name="mobile" id="mobile" value="" placeholder="Mobile No"></p>
        <p><input type="text" name="email" id="email" value="" placeholder="E-Mail ID"></p>
        <input type="hidden" name="party_code" value="<c:out value="${requestScope.party_code}"></c:out>" />
        <p class="submit"><input type="submit" name="commit" id="commit" value="Submit"></p>
      </form>
    </div>
  </section>

  <section class="about">
     <p class="about-author">
     Site Developed by IT Cell, The Durgapur Projects Limited.
  </section>
</body>
</html>