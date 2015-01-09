<%@page import="com.bean.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Server side pagination with ajax call using jsp servlet</title>
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
	padding: 5px 10px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	-webkit-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	-moz-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	text-shadow: rgba(0, 0, 0, .4) 0 1px 0;
	color: white;
	font-size: 14px;
	font-family: Georgia, serif;
	text-decoration: none;
	vertical-align: middle;
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
</style>
<script type="text/javascript">
	function createRequestObject() {
		var xmlhttpobject;
		try {
			xmlhttpobject = new window.XMLHttpRequest();
			xmlhttpobject.overrideMimeType('text/xml');
		} catch (e) {
			try {
				xmlhttpobject = new window.ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlhttpobject = new window.ActiveXObject(
							"microsoft.XMLHTTP");
				} catch (e) {
					alert("your browser doesn't support AJAX");
				}
			}
		}
		return xmlhttpobject;
	}
	var newArticleRequest;
	function loadArticleList() {//To get first page of article list
		newArticleRequest = createRequestObject();
		var url = "article?action=load";
		newArticleRequest.open("POST", url, true);
		newArticleRequest.send(null);//Submiting the request to a servlet.
		newArticleRequest.onreadystatechange = function() {
			processNewArticle();
		};
	}
	function getNextArticleList() {//To get next page of article list
		newArticleRequest = createRequestObject();
		var url = "article?action=next";
		newArticleRequest.open("POST", url, true);
		newArticleRequest.send(null);//Submiting the request to a servlet.
		newArticleRequest.onreadystatechange = function() {
			processNewArticle();
		};
	}
	function getPrevoiusArticleList() {//To get previous page of article list
		newArticleRequest = createRequestObject();
		var url = "article?action=previous";
		newArticleRequest.open("POST", url, true);
		newArticleRequest.send(null);//Submiting the request to a servlet.
		newArticleRequest.onreadystatechange = function() {
			processNewArticle();
		};
	}
	//this function will apend the result.jsp dynamically to this page.
	function processNewArticle() {
		if (newArticleRequest.readyState == 4) {
			var response = newArticleRequest.responseText;
			var spanid = "result";
			document.getElementById(spanid).innerHTML = response;
			window.document.getElementById(spanid).style.visibility = 'visible';
		}
	}
</script>
</head>
<body>
	<!-- This span to to append result.jsp dynamically to this page as a response of form submition -->
	<span id="result"> <jsp:include page="result.jsp"></jsp:include>
	</span>
</body>
</html>
