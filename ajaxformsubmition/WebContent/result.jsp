<!-- This page is the response of AddArticleServlet 
Here we have error message or success message and List of articles
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p style="font: italic; color: red;">${error}</p>
<p style="font: italic; color: blue;">${msg}</p>
<hr>
<c:forEach var="article" items="${articles}">
	<div class="divarticle">
		<h4>Title:${article.title}</h4>
		<p>${article.content}</p>
	</div>
	<hr>
</c:forEach>