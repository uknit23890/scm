<!-- --
@author Vinay Singh Rawat
 -->
<%@page import="com.bean.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.button {
	border-top: 1px solid #96d1f8;
	background: #65a9d7;
	background: -webkit-gradient(linear, left top, left bottom, from(#3e779d),
		to(#65a9d7) );
	background: -webkit-linear-gradient(top, #3e779d, #65a9d7);
	background: -moz-linear-gradient(top, #3e779d, #65a9d7);
	background: -ms-linear-gradient(top, #3e779d, #65a9d7);
	background: -o-linear-gradient(top, #3e779d, #65a9d7);
	padding: 1px 1px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px; border-radius : 4px;
	-webkit-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	-moz-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	text-shadow: rgba(0, 0, 0, .4) 0 1px 0;
	color: white;
	font-size: 12px;
	font-family: Georgia, serif;
	text-decoration: none;
	vertical-align: middle;
	-moz-border-radius: 4px;
	border-radius: 4px;
	border-radius: 4px;
}

.button:hover {
	border-top-color: #28597a;
	background: #28597a;
	color: #ccc;
}

.button:active {
	border-top-color: #1b435e;
	background: #1b435e;
}

.divform {
	border: 2px solid #a1a1a1;
	padding: 10px 40px;
	background: #ccccff;
	width: 1024px;
	border-radius: 25px;
}

.divarticle {
	border: 2px solid #a1a1a1;
	padding: 10px 40px;
	background: #dddddd;
	width: 1024px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD operation in hibernate</title>
</head>
<body>
	<h2>CRUD operation in hibernate</h2>
	<span style="font-style: italic; size: 10px; color: red;">${error}</span>
	<div class="divform">
		<div style="display:${cancelUpdate}">
			<form action="crud" method="get">
				<input type="submit" class="button" value="Cancel Update">
			</form>
		</div>
		<form action="crud" method="post">
			<input type="hidden" name="action" value="${action}"> <input
				type="hidden" name="id" value="${article.id}">
			<table>
				<tr>
					<td>Article Title:</td>
					<td><input type="text" name="title" value="${article.title}">
						<br></td>
				</tr>
				<tr>
					<td>Article Content:</td>
					<td><textarea rows="8" cols="100" name="content">${article.content}</textarea>
				</tr>
				<tr>
					<td colspan="1"><input type="submit" class="button"
						value="${btnValue}"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<span style="font-style: italic; size: 10px; color: red;">${msg}</span>
	<c:if test="${not empty list}">

		<c:forEach var="article" items="${list}">
			<div class="divarticle">
				<form action="crud" method="post">
					<input type="hidden" name="action" value="delete"> <input
						type="hidden" name="id" value="${article.id}"> <input
						type="submit" class="button" value="Delete Article">
				</form>
				<h4>Title:${article.title}</h4>
				<p>${article.content}</p>
				<form action="crud" method="post">
					<input type="hidden" name="action" value="edit"> <input
						type="hidden" name="id" value="${article.id}"> <input
						type="submit" class="button" value="Edit Article">
				</form>
			</div>
			<br>
		</c:forEach>

	</c:if>
</body>
</html>