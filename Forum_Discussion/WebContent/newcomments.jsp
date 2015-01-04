<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="model.Comment;"%>

<table width="100%" >
<%
ArrayList<Comment> newComments = (ArrayList<Comment>) session.getAttribute("newcomments");

	for (int i =newComments.size(); i > 0; i--) {
		Comment comment = newComments.get(i-1);
		
%>
				<tr>
					<td align="left"><%=comment.getUserid()%></td>
					<td align="right"><%=comment.getTimeText()%></td>
				</tr>
				<tr>
					<td align="left" colspan="2"><pre> <%=comment.getComment()%></pre></td>
				</tr>

				<%
					}
				%>
</table>
