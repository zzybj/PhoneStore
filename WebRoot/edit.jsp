<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="zzy.phoneStore.dao.*"%>
<%@ page import="zzy.phoneStore.utils.*"%>
<%@ page import="zzy.phoneStore.servlet.*"%>
<%@ page import="zzy.phoneStore.bean.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
#edittable {
	margin-left: 540px;
	margin-top: 50px;
}

.firstname {
	width: 125px;
	align: center;
}
.edita {
	color: black;
}
.editsub{
	margin-left:680px;
	margin-top:30px;
}
</style>
</head>

<body>
	<%@include file="head.jsp"%>
	<%@include file="menu.jsp"%>
	<%
		PhoneBean pb = null;
		if(request.getSession().getAttribute("pn")!=null){
			pb = (PhoneBean)request.getSession().getAttribute("pn");
			request.getSession().setAttribute("address", pb.getAddress());
		}
	 %>
	<div id="editcontent">
		<form action="${pageContext.request.contextPath}/AlterMessServlet">
			<table id="edittable" border="1" cellspacing="0">
				<tr>
					<th class="firstname">商品名称:</th>
					<td><input type="text" value="<%=pb.getPhonename()%>" name="phonename"/></td>
				</tr>		
				<tr>
					<th class="firstname">商品单价:</th>
					<td><input type="text" value="<%=pb.getPrice()%>"name="price" /></td>
				</tr>
			</table>
			<table class="editsub">
				<tr>
					<td><input type="submit" value="确定"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<%@include file="foot.jsp"%>
	</div>
</body>
</html>
