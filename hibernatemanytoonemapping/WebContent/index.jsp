<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Many to one mapping in hibernate example:Add persons along with same address</title>
</head>
<body>
	<form action="add" method="post">
		<h2>
			<b>Add persons having same address</b>
		</h2>
		<font color="red">${msg}</font>
		<hr>

		<table>
			<tr>
				<td>Address</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Street</td>
				<td><input type="text" name="street"></td>
			</tr>
			<tr>
				<td>Zip Code</td>
				<td><input type="text" name="zipCode"></td>
			</tr>
		</table>


		<hr>
		<table>
			<tr>
				<td>Name of first Person</td>
				<td><input type="text" name="person_name1"></td>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td>Name of 2nd Person</td>
				<td><input type="text" name="person_name2"></td>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td>Name of 3rd Person</td>
				<td><input type="text" name="person_name3"></td>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td>Name of 4rth Person</td>
				<td><input type="text" name="person_name4"></td>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td colspan="1"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>