<%@ include file="header.jsp"%>
<a href = "start.jsp">Back to Main</a>
<%if(request.getAttribute("errors")!=null){ %>
<fieldset style="color: black">
<legend>Error Message</legend>
<h5><%= request.getAttribute("errors") %></h5>
</fieldset>
<%} %>
<%@ include file="footer.jsp"%>