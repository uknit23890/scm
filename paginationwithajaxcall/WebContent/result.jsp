<%@page import="com.bean.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<h2>Server side pagination with ajax call using jsp servlet</h2>
<!-- this button to get first page of articles -->
<input type="button" class="button" value="Get article list"
	onclick="loadArticleList()">
<br />
<br />
<c:if test="${not empty list}">
	<!-- if number size of list is eq to number of news to be displayed in a page previous button  will not be displayed -->
	<c:if test="${btnPrevious!='' && btnPrevious!='Previous Disabled'}">
		<input type="button" class="button" value="${btnPrevious}"
			onclick="getPrevoiusArticleList()" />
	</c:if>
	<%
		List<Article> list = (List<Article>) session
					.getAttribute("list");
	%>
	<div>
		<c:if test="${not empty startIndex && not empty endIndex}">
			<%
				for (int j = (Integer) session.getAttribute("startIndex"); j < (Integer) session
								.getAttribute("endIndex"); j++) {
							if (j < list.size()) {
								Article article = list.get(j);
								if (article != null) {
			%>
			<hr>
			<c:set var="article" value="<%=article%>"></c:set>
			<h4>${article.id}.${article.title}</h4>
			<p>${article.content}</p>
			<%
				}
							}
						}
			%>
		</c:if>
		<hr>
	</div>
	<!-- if number size of list is eq to number of news to be displayed in a page next button  will not be displayed -->
	<c:if test="${btnNext!=''&& btnNext!='Next Disabled'}">
		<input type="button" class="button" value="${btnNext}"
			onclick="getNextArticleList()">
	</c:if>
</c:if>

