<%@include file="header.jsp"%>
<a href = "start.jsp">Back to Main</a>
<fieldset>
	<form action="addDoc" method="post">
		<table>
			<tr>
				<td>Regi. No.</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>

				<td>Contact:</td>
				<td><input type="text" name="Contact"></td>
			</tr>
			<tr>

				<td>Gender</td>
				<td><input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female">Female <input
					type="radio" name="gender" value="others">others</td>
			</tr>
			<tr>

				<td>DOB:</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>

				<td>Specialization :</td>
				<td><select name="specialization">

						<option value=" Dermatology">Dermatology</option>
						<option value="Dentistry">Dentistry</option>
						<option value="ENT">ENT</option>
						<option value="Medicine">Medicine</option>
						<option value="Neuro Surgery">Neuro Surgery</option>
						<option value="Orthopaedics">Orthopaedics</option>
						<option value="Plastic Surgery">Plastic Surgery</option>
						<option value="Radio Therapy">Radio Therapy</option>


				</select></td>


			</tr>
			<tr>
				<td>Designation:</td>
				<td><select name="Designation">
						<option value="Junior Resident">Junior Resident</option>
						<option value="Senior Resident">Senior Resident</option>
						<option value="Medical Officer">Medical Officer</option>
						<option value="Medical Superintendent">Medical
							Superintendent</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Add"
					autofocus="autofocus"></td>
			</tr>
		</table>


	</form>



</fieldset>
<%@include file="footer.jsp"%>