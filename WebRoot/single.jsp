<%@ page language="java" import="java.util.*"	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="zzy.phoneStore.dao.*" %>
<%@ page import="zzy.phoneStore.utils.*" %>   
<%@ page import="zzy.phoneStore.servlet.*" %>   
<%@ page import="zzy.phoneStore.bean.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>详细信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
	.singleimg{
		float:left;
		margin-left: 360px;
		margin-top: 50px;
		width: 270px;
		height: auto;
	}
	.singleimg{
		padding: 5px;
		border: 1px solid #ccc;
		border-radius: 5px;
		box-shadow: 0 0 5px #ccc;
	}
	.singleimg img{
		width: 260px;
		height: 300px;
	}
	.singlemessage{
		width: 300px;
		height: auto;
		padding-left: 700px;
		padding-top: 50px;
	}
</style>
</head>

<body>
	<%@include file="head.jsp"%>
	<%@include file="menu.jsp"%>
	<%@include file="searchbar.jsp"%>
	<%
		String address = request.getParameter("address");
		String method = request.getParameter("method");
		PhoneBean pb = PhoneDao.findPhones(address, method);
	 %>
	<div class="singlecontent">
		<form action="${pageContext.request.contextPath}/AlterCartServlet" method="post">
			<div class="singleimg">
		  		<img src="images/<%=method %>/<%=address %>.jpg">
		  	</div>	
		  	<div class="singlemessage">
		  		<p><%=pb.getPhonename()%></p>
		  		<p>¥<%=pb.getPrice() %></p>
				<input type="submit" value="加入购物车" onclick="add();"/>
			</div>
			<script>
				function add(){
					<%
						request.getSession().setAttribute("phone", pb);
					%>
				}
			</script>
		</form>
	</div> 
	<div>
		<%@include file="foot.jsp"%>
	</div>
</body>
</html>
