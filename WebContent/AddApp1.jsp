<%@include file="header.jsp"%>
<a href = "start.jsp">Back to Main</a>
<fieldset>
	<form action="addApp1" method="post">

		<table>

			<tr>
				<td>Enter patient ID:</td>
				<td><input type="text" name="pId"></td>
				<td><a href="AddPatient.jsp">Add new patient</td>
			</tr>

			<tr>

				<td>Dept :</td>
				<td><select name="dept">

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
			<td colspan="3" align="right"><input type="submit" value="search doc"
				autofocus="autofocus"></td>
		</table>


	</form>
<%if(request.getAttribute("errors")!=null){ %>
<fieldset style="color: black">
<legend>Error Message</legend>
<h5><%= request.getAttribute("errors") %></h5>
</fieldset>
<%} %>

</fieldset>
<%@include file="footer.jsp"%>