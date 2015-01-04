<%@page import="model.User;"%>


<link href="forum_css/style.css" rel="stylesheet" type="text/css">
<%
	User u = (User) request.getSession().getAttribute("user");
%>
<table BORDER=0 CELLPADDING=0 CELLSPACING=5 align="center">
	<tr>
		<TD>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="74"><a href="index.jsp"><img src="images/forum.jpg" height="75"
					width="300" align="left" border="0"></a></td>
				<td width="343" valign="middle" align="center"><span
					class="title">Discussion Forum</span></td>
				<td width="300" background="images/banner_bg.jpg"></td>
				<td width="303"><img src="images/banner.jpg"></td>
			</tr>
		</table>
		</TD>
	</tr>
	
	
	<tr bgcolor="#E0E0E0">
		<td height="25" valign="middle">
		<table width="100%">
			<tr>
				<td align=right><b>Hi <%=u.getName()%></b>&nbsp;|&nbsp;
				<a href='SignOut'>Sign Out</a>
				</td>



			</tr>
		</table>
		</td>
	</tr>
	

<!--	<tr align="center">-->
<!--		<td valign="top" bgcolor="#CCFF99" align="justify"><img src="images/forumleft.jpg"-->
<!--			 border="1">Welcome to Forum</td>-->
<!--		-->
<!---->
<!--	</tr>-->
	

</table>

