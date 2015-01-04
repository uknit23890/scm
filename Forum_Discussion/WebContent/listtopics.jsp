<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	List<Topic> topics = (List<Topic>) request.getAttribute("topics");
%>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<title>welcome to FORUM</title>

</head>
<jsp:include page="headerHome.jsp" />
<body>
<table height="auto" width="1250" align="center" >

	<tr>
		<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
		<td valign="top">
<!--		<h1 align="center">Topics</h1>-->
		<%
			String message = (String) request.getAttribute("message");
			if (message != null)
				out.println(message);
			if (topics.size() > 0) {
		%>
		<table id="box-table-a">
			<thead>
				<tr>
					<th align="left" scope="col">SL.No</th>
					<th align="left" scope="col">Topic</th>
					<th align="left" scope="col">Comment</th>
					<th align="left" scope="col">UserID</th>
					<th align="left" scope="col">Time</th>
				</tr>
			</thead>
			<tbody>
				<%
					int i = 1;
						for (Topic topic : topics) {
				%>
				<tr>
					<td align="left"><%=i++%></td>
					<td align="left"><u><a
						href="TopicDetails?id=<%=topic.getId()%>"><%=topic.getName()%></a></u></td>
					<td align="left"><pre><%=topic.getComment()%></pre></td>
					<td align="left"><%=topic.getUserid()%></td>
					<td align="left"><%=topic.getTimeText()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			} else {
		%>
		<h4>There are not topics.</h4>
		<a href="AddTopic"> Click here to Add new Topic</a> <%
 	}
 %>
		</td>
	</tr>
	
</table>

</body>
<jsp:include page="footer.jsp" />
</html>