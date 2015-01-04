<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

</head>
<body>
<table>
	<tr>
		<jsp:include page="header.jsp" />
	</tr>
	<tr>
		<td align="center">

		<center><h1>Welcome to FORUM Registration</h1></center>
		<center><%
			String message = (String) request.getAttribute("message");
			if (message != null){%>
				<img src="images\error1.jpg"> <%out.println("<font color=\"red\"><b>"+message+"</b></font>"); %>
		<%}%></center>
		<form action="Registration" method="post" name="reg">
		<table width="355" border="0" cellspacing="1" cellpadding="3"
			align="center">
			<tr bgcolor="#6699CC" align="center"> 
						<td colspan="2" align="center"><font color="#FFFFFF">
							<b>Register Form</b></font>
						</td>
				
					</tr>
			
			<tr bgcolor="#E7E7E7">
				<td width="150">
							&nbsp;<b>Userid</b></td>
				
				<td><input type="text" value="Enter valid mail Id"
					name="userid" onfocus="change()"></td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td width="150">
							&nbsp;<b>Password</b></td>
				
				<td><input type="password" name="password"></td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td width="150">
							&nbsp;<b>Confirm Password</b></td>
				
				<td><input type="password" name="confirmPassword"></td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td width="150">
							&nbsp;<b>Name</b></td>
			
				<td><input type="text" name="name"></td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td width="150">
							&nbsp;<b>Gender</b></td>
				
				<td><input type="radio" name="gender" value="M"> Male <input
					type="radio" name="gender" value="F"> Female</td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td width="150">
							&nbsp;<b>Date Of Birth</b></td>
				
				<td><select name="day"><option value="">day</option>
				<option value="1">1</option><option value="2">2</option>
				<option value="3">3</option><option value="4">4</option>
				<option value="5">5</option><option value="6">6</option>
				<option value="7">7</option><option value="8">8</option>
				<option value="9">9</option><option value="10">10</option>
				<option value="11">11</option><option value="12">12</option>
				<option value="13">13</option><option value="14">14</option>
				<option value="15">15</option><option value="16">16</option>
				<option value="17">17</option><option value="18">18</option>
				<option value="19">19</option><option value="20">20</option>
				<option value="21">21</option><option value="22">22</option>
				<option value="23">23</option><option value="24">24</option>
				<option value="25">25</option><option value="26">26</option>
				<option value="27">27</option><option value="28">28</option>
				<option value="29">29</option><option value="30">30</option value="31"><option>31</option>
				</select>
				<select name="month"><option value="">month</option>
				<option value="1">1</option><option value="2">2</option>
				<option value="3">3</option><option value="4">4</option>
				<option value="4">5</option><option value="6">6</option>
				<option value="7">7</option><option value="8">8</option>
				<option value="8">9</option><option value="10">10</option>
				<option value="11">11</option><option value="12">12</option></select>
				
				<select name="year"><option value="">year</option>
				<option value="1980">1980</option><option value="1981">1981</option>
				<option value="1982">1982</option><option value="1983">1983</option>
				<option value="1984">1984</option><option value="1985">1985</option>
				<option value="1986">1986</option><option value="1987">1987</option>
				<option value="1988">1988</option><option value="1989">1989</option>
				<option value="1990">1990</option><option value="1991">1991</option>
				<option value="1992">1992</option><option value="1993">1993</option>
				<option value="1994">1994</option><option value="1995">1995</option>
				<option value="1996">1996</option><option value="1997">1997</option>
				<option value="1998">1998</option><option value="1999">1999</option>
				<option value="2000">2000</option><option value="2001">2001</option>
				<option value="2002">2002</option><option value="2003">2003</option>
				
				</select>
				</td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td width="150">
							&nbsp;<b>City</b></td>
				
				<td><select name="city">
					<option value=""><b>Select City</b></option>
					<option value="Lucknow">Lucknow</option>
					<option value="Kanpur">Kanpur</option>
					<option value="Allahabad">Allahabad</option>
					<option value="Varanasi">Varanasi</option>
				</select></td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td colspan="3" align="center"><input type="submit"
					value="Register">	<input type="reset" value="Reset"></td>
			</tr>
		</table>
		</form>
	</td>
	</tr>
	<tr><td>
	<jsp:include page="footer.jsp" />
	</td></tr>
	
</table>

</body>

</html>