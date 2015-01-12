<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>WebSpringBasic</title>
</head>
<body>
	<div style="font: italic; color: red;">${msg }</div>
	<div>
		<hr>
		<form:form action="signup" method="post" commandName="userForm"
			id="identicalForm">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input path="name" placeholder="Name" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" placeholder="Email" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" placeholder="Password" /></td>
				</tr>
				<tr>

					<td colspan="1"><form:radiobutton path="gender" value="M" />Male
						<form:radiobutton path="gender" value="F" />Female</td>
				</tr>
				<tr>
					<td colspan="1">
						<button class="btn btn-primary btn-sm" type="submit">Submit</button>
					</td>
				</tr>
			</table>
		</form:form>
		<hr>
	</div>
</body>

</html>