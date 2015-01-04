<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="data.*" %>
     <%@ page import="model.*" %>
      <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	List<Topic> topics = (List<Topic>)request.getAttribute("topics");
%>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome to FORUM</title>

</head>
<jsp:include page="headerHome.jsp" />
<body>
<table height="auto" width="1250" align="center">
	
	<tr>
	<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
		<td valign="top">
<!--		<h1 align="center"> My Topics</h1>-->
		<%
		String message = (String)request.getAttribute("message");
		if(message != null)
			out.println(message);
		
			if(topics.size() > 0)
			{
		%>
		<table id="box-table-a">
		<thead>
		<th align="left">Sl.No</th>
		<th align="left">Name</th>
		<th align="left">First Comment</th>
		<th align="left">Time</th>
		<th align="left">Action</th>
		</thead>
		<tbody>
			<%
			int i = 1;
			for(Topic topic: topics){
				
				%>
				<tr>
				<td align="left"><%=i++ %></td>
				<td align="left"><%=topic.getName() %></td>
				<td align="left"><%=topic.getComment() %></td>
				<td align="left"><%=topic.getTimeText()%></td>
				<td align="left">
				<form action="EditTopic" method="post">
					<input type="hidden" name="id" value="<%=topic.getId()%>"/>
					<input type="submit" value="Edit"/>
				</form>
				</td>
				</tr>
				
				<%
			}
			
			%>
		</tbody>
		</table>
		<%
			}else{
				%>
				<h4> You have not added topics.</h4>
				<a href="AddTopic"> Click here to Add new Topic</a>
				<%
			}
		%>
	</td>
	</tr>

</table>
<jsp:include page="footer.jsp"/>
</body>
</html>