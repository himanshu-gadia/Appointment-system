<%@page import="java.util.ArrayList"%>
<%@page import="com.bo.AppointmentInfo"%>
<%@include file="header.jsp"%>
<h4>Check appointment list</h4>
<hr>
<a href="start.jsp">Back to Main</a>
<form action="ListOpen" method="post">
	<table>
		<tr>
			<td>Enter your id:</td>
			<td><input type="text" name="docid"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="Open"
				autofocus="autofocus"></td>
		</tr>
	</table>
</form>
<hr>

<%
	if (request.getAttribute("errors") != null) {
%>
<fieldset style="color: black">
	<legend></legend>
	<h5><%=request.getAttribute("errors")%></h5>
</fieldset>
<%} %>

<%@include file="footer.jsp"%>
