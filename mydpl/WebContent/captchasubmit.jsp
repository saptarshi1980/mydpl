<%@ page import="nl.captcha.Captcha"%>

<%
	Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
	request.setCharacterEncoding("UTF-8");
	String answer = request.getParameter("answer");
	if (captcha.isCorrect(answer)) {
		request.setAttribute("valid", "Y");
%>
<jsp:forward page="/WEB-INF/jsp/quickpay.jsp"/>  <%
 	
	} else {
 %><jsp:forward page="captchaMydpl.jsp"/> <%
 	}
 %>


