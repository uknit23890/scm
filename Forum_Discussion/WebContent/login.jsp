<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Forum Login</title>

</head>
<body>
<jsp:include page="header.jsp" />
<table BORDER=0 CELLPADDING=0 CELLSPACING=5 align="center">

	<tr>
		<td align="center" height="200">

		<h1>Welcome to FORUM Login</h1>
		<%
			String message = (String) request.getAttribute("message");
			if (message != null)
				out.println(message + "<br>");
		%>
		<form action="Login" method="post">
		<table width="250" border="0" cellspacing="1" cellpadding="3"
			align="center">
			<tr bgcolor="#6699CC">
				<td colspan="2" align="center"><font color="#FFFFFF"> <b>Login
				Form</b></font></td>
			</tr>

			<tr bgcolor="#E7E7E7">
				<td width="150">&nbsp;<b>Userid</b></td>
				
				<td><font face="Verdana"><input type="text" name="userid" size = 25 maxlength = 100></font></td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td width="150">&nbsp;<b>Password</b></td>
			
				<td><font face="Verdana"><input type="password" name="password" size = 25 maxlength = 100></font></td>
			</tr>
			<tr bgcolor="#D9DBDE">
				<td colspan="2" align="center"><input type="submit" value="Sign In">
				<input type="reset" value="Reset">
				</td>
			</tr>
		</table>
		</form>
	</tr>

</table>

</body>
<footer><jsp:include page="footer.jsp"/></footer>
</html>