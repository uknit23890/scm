<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="data.*" %>
    <%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="topic" scope="request" class="model.Topic"/>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome to FORUM</title>
<style>
</style>
</head>
<jsp:include page="headerHome.jsp" />
<body>
<table height="auto" width="1250" align="center">
	
	<tr>
			<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>

		<td align="center"  height="300">
		<h1> <%=topic.getName() %></h1>
			<%
			String message = (String) request.getAttribute("message");
			if (message != null){%>
				<img src="images\error1.jpg"> <%out.println("<font color=\"red\"><b>"+message+"</b></font>"); %>
		<%}%>
		<form action="UpdateTopic" method="post">
		<input type="hidden" name="id" value="<%=topic.getId()%>"/>
		<textarea rows="5" cols="20" name="comments"><%=topic.getComment() %></textarea>
		<br>
		<input type="submit" value="Update"/>
		</form>
		
	
	</tr>
	<tr>
		<td colspan="2" align="center" >
		<jsp:include page="footer.jsp"/></td>

	</tr>
</table>

</body>
</html>