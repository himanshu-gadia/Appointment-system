<%@include file="header.jsp"%>
<div class="container">

	<form action="login" method="post">
		<table>
			<tr>
				<td>Login Id:</td>

				<td><input type="text" name="login_id"
					placeholder="Enter username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="login_password"
					placeholder="Enter password"></td>

			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="login" autofocus="autofocus"></td>
			</tr>
		</table>

	</form>
	
	<%if(request.getAttribute("errors")!=null){ %>
	
	<div class="error">
	Error found:<%=request.getAttribute("errors") %> 
	</div>
	
	<%}%>
	

</div>
<%@include file="footer.jsp"%>