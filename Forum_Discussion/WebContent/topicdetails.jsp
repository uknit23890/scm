<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="data.*"%>
<%@ page import="model.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	Topic topic = (Topic) request.getAttribute("topic");
%>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome to FORUM</title>
<SCRIPT TYPE="text/javascript">
       <!--
    function createRequestObject()
    {
        var xmlhttpobject;
        try
        {
            xmlhttpobject = new window.XMLHttpRequest();
            xmlhttpobject.overrideMimeType('text/xml');
        }
        catch(e)
        {
            try{
                 xmlhttpobject = new window.ActiveXObject("Msxml2.XMLHTTP");
               }
               catch(e)
               {
                   try
                   {
                        xmlhttpobject = new window.ActiveXObject("microsoft.XMLHTTP");
                   }
                   catch(e)
                   {
                       alert("your browser doesn't support AJAX");
                   }
              }
        }
        return xmlhttpobject;
    }
-->    
</SCRIPT>
<SCRIPT TYPE="text/javascript">
       <!--
    
function hidecommenttext(id){
    if(id>=0){
        window.document.getElementById(id).style.visibility='hidden';
        window.document.getElementById(id).style.display='none';
    }
}

var s=0;
var newcommentRequest;
function AddNewComment(){
        
        newcommentRequest= createRequestObject();       
       
        var comment=document.getElementById('comment').value;
        var topicId=document.getElementById('topicId').value;         
       if(comment.trim().length == 0){
            alert('Enter your comment');
            }
        else 
            { 
         
            var url = "AddComment?comment="+comment+"&topicId="+topicId;   
            newcommentRequest.open("GET",url,true);
            newcommentRequest.onreadystatechange = function(){processNewComment()};
            newcommentRequest.send(null);
            }
    }    
          
     function processNewComment()
    {
        
        if(newcommentRequest.readyState == 4)
            {
                
                var response = newcommentRequest.responseText;
                var spanid="newcomments";
                  window.document.getElementById('comment').value="";
                window.document.getElementById("addcomment").style.visibility='hidden';
                window.document.getElementById("addcomment").style.display='none'; 
                document.getElementById(spanid).innerHTML = response;                
                window.document.getElementById(spanid).style.visibility='visible';
        
                 window.document.getElementById("nocomments").style.visibility='hidden';
                window.document.getElementById("nocomments").style.display='none';           
               
          }
           
            
    } 
    

function hideaddcommenttext(){
    
    window.document.getElementById("addcomment").style.visibility='hidden';
    window.document.getElementById("addcomment").style.display='none';
    document.getElementById('comment').value="";
    
} 
function ShowBox(id){
    
  
        window.document.getElementById(id).style.visibility='visible';
        window.document.getElementById(id).style.display='block';     
    
  
        document.getElementById("comment").focus();
   
}
-->    
</SCRIPT>
</head>
<jsp:include page="headerHome.jsp" />
<body>
<table height="auto" width="1250" align="center">
	<tr>
		
	</tr>
	<tr>
		<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
		<td align="left" height="300">
		<h1><%=topic.getName()%></h1>
		<p align="left">Created by: <%=topic.getUserid()%> <br>
		Created on: <%=topic.getTimeText()%> <br>
		Creator Comment :
		<pre><%=topic.getComment()%></pre> <br>
		<input type="hidden" id="topicId" value="<%=topic.getId()%>" />
		<h3>Comments</h3>
		<%
			String message = (String) request.getAttribute("message");
			if (message != null)
				out.println(message);

			List<Comment> comments = (List<Comment>) request
					.getAttribute("comments");
			if (comments.size() == 0) {
		%>
		<h4 id="nocomments">No Comments yet, Be the first one to comment.</h4>
		<%
			}
		%>
		<table  width="100%">

			<tbody>
				<tr>
					<td><input type="submit" value="Add New Comment"
						onclick="ShowBox('addcomment')" align="right" /></td>
				</tr>
				<tr>
					<td><span id="addcomment"
						style="visibility: hidden; display: none"> Your Comment<font
						color="red">*</font> <br>
					<textarea name="comment" id="comment" class="blur"
						onFocus="document.getElementById('comment').className='focus'"
						onBlur="document.getElementById('comment').className='blur'"
						rows="4" cols="35"></textarea> <br>
					<input type="button" name="save" value="save"
						onclick="AddNewComment()" align="right" /><a
						href="javascript:void(0)" onclick="hideaddcommenttext()"><button>Cancel</button>
					</a><br>
					<font color="red">*</font> Help us keep the Forum clean and
					respectful. </span></td>
				</tr>

			</tbody>
		</table>
		
		<span id="newcomments">
				
			
		</span>
		
		<table width="100%" border="1" bgcolor="#CCFFFF">

			<tbody>
				<%
					for (Comment comment : comments) {
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

			</tbody>
		</table>
	</tr>
	<tr>
		<td colspan="2" align="center"><jsp:include page="footer.jsp" /></td>

	</tr>
</table>

</body>
</html>