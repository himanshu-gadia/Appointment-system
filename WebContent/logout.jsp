<%@page import="com.bo.User" %>
<%@include file="header.jsp"%>
<a href = "login.jsp">Back to Login</a>
<fieldset>
	<legend></legend>
	<h2>
		<%=
			request.getAttribute("message")
		%>
	</h2>

</fieldset>
<%@include file="footer.jsp"%>