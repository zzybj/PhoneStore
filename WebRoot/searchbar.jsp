<%@page import="zzy.phoneStore.bean.UserBean"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <div id="search">
		<form action="${pageContext.request.contextPath}/SearchServlet" method="post">
			<table id="seartchmain">
				<tr>
					<td><input type="text" name="littername"/></td>
					<td><input type="submit" value="搜索"/></td>
				</tr>
			</table>
		</form>
	</div>
  </body>
</html>
