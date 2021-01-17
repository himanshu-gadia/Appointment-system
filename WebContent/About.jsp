<%@page import="com.bo.User"%>
<%@include file="header.jsp"%>
<%
	User user = null;
	if (session.getAttribute("loginUser") != null) {
		user = (User) session.getAttribute("loginUser");
	}
%>
<a href = "start.jsp">Back to Main</a>
<fieldset>
	<legend>About</legend>

	<table>
		<tr>
			<td><h3>Id:</h3></td>
			<td><h3><%=user.getId()%></h3></td>

		</tr>
		<tr>
			<td><h3>Name:</h3></td>
			<td><h3><%=user.getName()%></h3></td>

		</tr>
		<tr>
			<td><h3>Username:</h3></td>
			<td><h3><%=user.getUsername()%></h3></td>

		</tr>

		<tr>
			<td><h3>Role:</h3></td>
			<td><h3><%=user.getRollType()%></h3></td>

		</tr>
	</table>


</fieldset>
<%@include file="footer.jsp"%>