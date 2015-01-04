<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome to FORUM</title>
<style>
</style>
</head>
<body>

	<jsp:include page="headerHome.jsp" />
<table height="auto" width="1250" align="center">

	<tr>
<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
		<td align="center"  height="300">
		<h1 align="center"> Add Topic</h1>
		<%
			String message = (String) request.getAttribute("message");
			if (message != null){%>
				<img src="images\error1.jpg"> <%out.println("<font color=\"red\"><b>"+message+"</b></font>"); %>
		<%}%>
		<form action="AddTopic" method="post">
		<table>
		<tr>
		<td><b>Name:</b></td>
		<td> <input type="text" name="name" size="32"> </td><td valign="top"><br></td>
		
		</tr>
		<tr>
		<td><b>Comment:</b></td>
		<td><textarea rows="7" cols="25" name="comment"></textarea>
		</td><td valign="top"><br></td>
		
		</tr>
		<tr>
		<td colspan="2">
			<input type="submit" value="Add Topic">
		</td><td valign="top"><br></td>
	    
		</tr>
		</table>
		</form>
	</tr>
	
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>