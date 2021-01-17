<%@page import="com.bo.User"%>
<%@include file="header.jsp"%>

	<%
		User user = null;
		if (session.getAttribute("loginUser") != null) {
			user = (User) session.getAttribute("loginUser");
		}
	%>
<hr>
Hello!<%= user.getName() %>
<hr>
	<%
		if (user.getRollType().equalsIgnoreCase("admin")) {
	%>
<a href="AddPatient.jsp">add patient</a>
<a href="AddReceptionist.jsp">Add Receptionist</a>
<a href="AddDoctor.jsp">add Doctor</a>
<a href="AddApp1.jsp">Book appointment</a>
	<%
		} else if (user.getRollType().equalsIgnoreCase("receptionist")) {
	%>
<a href="AddPatient.jsp">add patient</a>
<a href="AddApp1.jsp">Book appointment</a>
	<%
		} else {
	%>
<a href="ApptTable.jsp">check appointment list</a>
	<%
		}
	%>
	<a href="About.jsp">About</a>
<a href = "logout">Log out</a>	
	<%
		if (request.getAttribute("acknowledgementMsg") != null) {
	%>
<fieldset style="color: black">
	<legend>Error Message</legend>
	<h5><%=request.getAttribute("acknowledgementMsg")%></h5>
</fieldset>
<%
	}
%>
<%@include file="footer.jsp"%>