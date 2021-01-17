<%@page import="com.bo.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bo.AppointmentInfo"%>
<%@include file="header.jsp"%>
<h4>Check appointment list</h4>
<hr>
<a href="start.jsp">Back to Main</a>
<hr>

<%
	Doctor doc = null;
	if (request.getAttribute("dObj") != null) {
		doc = (Doctor) request.getAttribute("dObj");
	}
%>
<table>
	<tr>
		<td>Entered id:</td>
		<td><input type="text" readonly="readonly" value=<%=doc.getId()%>></td>
	</tr>
</table>

<hr>
<table>

	<tr>
		<th>Appointment Id</th>
		<th>Patient Id</th>
		<th>Date:</th>
		<th>Time:</th>
	</tr>
	<%
		ArrayList<AppointmentInfo> list = null;
		if (request.getAttribute("arrList") != null) {
			list = (ArrayList<AppointmentInfo>) request
					.getAttribute("arrList");
		}
		for (AppointmentInfo app : list) {
	%>
	<tr>
		<td><%=app.getId()%></td>
		<td><%=app.getPatientId()%></td>
		<td><%=app.getAppointmentDate()%></td>
		<%
			if (app.getTiming() == 900) {
		%>
		<td>9 AM</td>
		<%
			} else {
		%>
		<td>2 PM</td>
		<%
			}
		%>
	</tr>
	<%
		}
	%>
</table>



<%@include file="footer.jsp"%>
