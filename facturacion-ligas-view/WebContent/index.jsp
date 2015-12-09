<%
	session.invalidate();
	response.sendRedirect(request.getContextPath() + "/resources/modules/main.html");
%>