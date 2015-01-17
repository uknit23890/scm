<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add paper and questions</title>
</head>
<body>
	<form action="add" method="post">
		<h2>
			<b>Add paper along with questions...</b>
		</h2>
		<font color="red">${msg}</font>
		<hr>
		<table>
			<tr>
				<td>Paper Name:</td>
				<td><input type="text" name="paperName"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><textarea rows="3" cols="60" name="description"></textarea>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td>Question:</td>
				<td><textarea rows="1" cols="60" name="question1"></textarea></td>
			</tr>
			<tr>
				<td>Answer:</td>
				<td><textarea rows="3" cols="60" name="answer1"></textarea></td>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td>Question:</td>
				<td><textarea rows="1" cols="60" name="question2"></textarea></td>
			</tr>
			<tr>
				<td>Answer:</td>
				<td><textarea rows="3" cols="60" name="answer2"></textarea></td>
			</tr>
		</table>
		<hr>
		<table>
			<tr>
				<td colspan="1"><input type="submit" value="Add Paper"></td>
			</tr>
		</table>
	</form>
</body>
</html>