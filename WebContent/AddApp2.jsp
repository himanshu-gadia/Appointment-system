<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bo.Patient"%>
<%@page import="com.bo.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp"%>
<fieldset>
	<legend>Select </legend>
	<form action="addApp2" method="post">
		<%
			Patient patient = null;
			if (request.getAttribute("patientObj") != null) {
				patient = (Patient) request.getAttribute("patientObj");
			}
		%>
		<table>
			<tr>
				<td>Patient Id:</td>
				<td><input type="text" readonly="readonly" name="pId"
					value=<%=patient.getId()%>></td>
			</tr>

		</table>
		<table id="doctorlist">
			<tr>
				<th></th>
				<th>Doctor ID</th>
				<th>Name</th>
				<th>Designation</th>
			</tr>
			<%
				ArrayList<Doctor> docList = null;
				if (request.getAttribute("doctorList") != null) {
					docList = (ArrayList<Doctor>) request
							.getAttribute("doctorList");
				}
				for (Doctor d : docList) {
			%>
			<tr>
				<td><input type="radio" name="docId" value=<%=d.getId()%>></td>
				<td><%=d.getId()%></td>
				<td><%=d.getName()%></td>
				<td><%=d.getDesignation()%></td>
			</tr>
			<%
				}
				LocalDate date = null;
				date = LocalDate.now();
				System.out.println(date);
			%>
			<tr>
				<td>Select Appointment Date:</td>
				<td><input type="date" name="appdate" min=<%=date%>></td>
			</tr>
			<tr>

				<td>Select Appointment shift:</td>
				<td><select name="appshift">
						<option value="morning">Morning</option>
						<option value="evening">Evening</option>
				</select></td>
			</tr>
			<td colspan="3" align="right"><input type="submit"
				value="Book appointment" autofocus="autofocus"></td>
		</table>




	</form>
</fieldset>

<%
	if (request.getAttribute("errors") != null) {
%>
<fieldset style="color: black">
	<legend>Error Message</legend>
	<h5><%=request.getAttribute("errors")%></h5>
</fieldset>
<%
	}
%>
<%@include file="footer.jsp"%>