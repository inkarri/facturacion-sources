<%
	session.invalidate();
	response.sendRedirect(request.getContextPath() + "/resources/modules/scripts/facturacion/view/main.html");
%>