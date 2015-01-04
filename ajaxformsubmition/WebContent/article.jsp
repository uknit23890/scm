<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome to FORUM</title>

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
	function addNewArticle() {
		newArticleRequest = createRequestObject();
		var content = document.getElementById('content').value;
		var title = document.getElementById('title').value;
		var url = "add?title=" + title + "&content=" + content;
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

	<div>
		<form>
			<table>
				<tr>
					<td>Article Title:</td>
					<td><input type="text" id="title"></td>
				</tr>
				<tr>
					<td>Article Content:</td>
					<td><textarea id="content" rows="4" cols="40"></textarea>
				</tr>
				<tr>
					<td colspan="1"><input type="button" name="save" value="save"
						onclick="addNewArticle()" align="right" /></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- This span to to append result.jsp dynamically to this page as a response of form submition -->
	<span id="result"> <jsp:include page="result.jsp"></jsp:include>
	</span>
</body>
</html>