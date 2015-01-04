<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="forum_css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome to FORUM</title>

</head>

	<jsp:include page="headerHome.jsp" />
<body>

			
		
<table height="auto" width="auto" align="center">
	
	<tr><td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
		<td align="center" height="300">
<!--		<h1>Home</h1>-->
			<%
			String message = (String) request.getAttribute("message");
			if (message != null){%>
				<img src="images\error1.jpg"> <%out.println("<font color=\"red\"><b>"+message+"</b></font>"); %>
		<%}%>
		<p>Welcome to forum.... <br>
		Happy Discussion!
	</tr>
	<tr>
		<td colspan="2" align="center"><jsp:include page="footer.jsp" /></td>

	</tr>
</table>

</body>
</html>