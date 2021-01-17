<%@include file="header.jsp"%>
<h4>Add receptionist</h4>
<a href="start.jsp">Back to Main</a>
<fieldset>
	<form action="Add" method="post">
		<table>
			<tr>
				<td>Enter Aadhar Number:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>Contact :</td>
				<td><input type="text" name="contact"
					placeholder="e.g., 9777666655"></td>
			</tr>

			<tr>
				<td>Secondary Contact :</td>
				<td><input type="text" name="sec_contact"></td>
			</tr>

			<tr>
				<td>DOB :</td>
				<td><input type="date" name="dob"></td>
			</tr>

			<tr>
				<td>Gender :</td>
				<td><input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female"> Female <input
					type="radio" name="gender" value="others"> Other</td>

			</tr>

			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"
					placeholder="e.g., abc@xyz.com"></td>
			</tr>

			<tr>
				<td>Pincode :</td>
				<td><input type="text" name="pincode"
					placeholder="e.g., 335513"></td>
			</tr>

			<td colspan="2" align="right"><input type="submit" value="Add"
				autofocus="autofocus"></td>
		</table>

	</form>

</fieldset>

<%@include file="footer.jsp"%>