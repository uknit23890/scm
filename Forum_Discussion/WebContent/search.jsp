<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="data.*" %>
     <%@ page import="model.*" %>
      <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<h1> Search</h1>
		<form action="Search" method="post">
		<table><tr><td>
		Enter the search text:<input type="text" name="searchtext"/></td><td><input type="submit" value="Search"></td>
		</tr>
		</table>
		</form>
		<%
			String message = (String) request.getAttribute("message");
			if (message != null){%>
				<img src="images\error1.jpg"> <%out.println("<font color=\"red\"><b>"+message+"</b></font>"); %>
		<%}%>
		<%
		List<Topic> topics = (List<Topic>)request.getAttribute("topics");
		if(topics != null && topics.size() > 0){
			%>
			<br>Search results for "<u><%=request.getParameter("searchtext") %></u>"
	<table id="box-table-a">
		<thead>
		<th align="left">Sl.No</th>
		<th align="left">Name</th>
		<th align="left">First Comment</th>
		<th align="left">Userid</th>
		<th align="left">Time</th>
		</thead>
		<tbody>
			<%
			int i = 1;
			for(Topic topic: topics){
				
				%>
				<tr>
				<td align="left"><%=i++ %></td>
				<td align="left"><a href="TopicDetails?id=<%=topic.getId()%>"><%=topic.getName() %></a></td>
				<td align="left"><%=topic.getComment() %></td>
				<td align="left"><%=topic.getUserid() %></td>
				<td align="left"><%=topic.getTimeText() %></td>
				</tr>
				
				<%
			}
			
			%>
		</tbody>
		</table>
			<%
		}
		else{
			if(request.getParameter("searchtext") != null){
			%>
			<font color="red"><b><br>No results found for "<u><%=request.getParameter("searchtext") %></u>" </b> </font>
			<%
			}
		}
		%>
		
	</tr>
	
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>