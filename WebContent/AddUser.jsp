<%@include file="header.jsp"%>
<a href="start.jsp">Back to Main</a>
<fieldset>
	<form action="AddUser" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Enter username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Enter password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>RoleType :</td>
				<td><input type="radio" name="roletype" value="admin">Admin
					<input type="radio" name="roletype" value="receptionist">Receptionist
					<input type="radio" name="roletype" value="doctor"> Doctor
			</tr>

			<td colspan="2" align="right"><input type="submit" value="Add"
				autofocus="autofocus"></td>
		</table>

	</form>

</fieldset>
<%@include file="footer.jsp"%>