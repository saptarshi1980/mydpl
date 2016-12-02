<%@ page import="nl.captcha.Captcha"%>

<%
	Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
	request.setCharacterEncoding("UTF-8");
	String answer = request.getParameter("answer");
	if (captcha.isCorrect(answer)) {
%>
<jsp:forward page="/NewConnHandler"/>  <%
 	
	} else {
 %><jsp:forward page="captcha.jsp"/> <%
 	}
 %>


