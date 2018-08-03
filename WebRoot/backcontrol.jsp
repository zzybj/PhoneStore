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
#backtable {
	margin-left: 270px;
	margin-top: 30px;
}

.firstname {
	width: 125px;
	align: center;
}

.backa {
	color: black;
}
</style>
<script type="text/javascript">
	function del() {
		document.getElementById('del').value = document.getElementById('del').value - 1;
	}
	function add() {
		document.getElementById('add').value = document.getElementById('add').value + 1;
	}
</script>
</head>

<body>
	<%
		 if(request.getSession().getAttribute("user")==null){
		 	response.sendRedirect("login.jsp");	
		 	return ;
		 }
	 %>
	<%@include file="head.jsp"%>
	<%@include file="menu.jsp"%>
	<div id="search">
		<form
			action="${pageContext.request.contextPath}/SearchServlet?search=xiugai"
			method="post">
			<table id="seartchmain">
				<tr>
					<td><input type="text" name="littername" /></td>
					<td><input type="submit" value="搜索" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="backcontent">
		<form action="${pageContext.request.contextPath}/AlterPhoneServlet">
			<table id="backtable" border="1" cellspacing="0">
				<tr>
					<th class="firstname">序号</th>
					<th class="firstname">商品名称</th>
					<th class="firstname">商品单价</th>
					<th class="firstname">数量</th>
					<th class="firstname">修改</th>
					<th class="firstname">删除</th>
				</tr>
				<c:forEach var="phone" items="<%=PhoneDao.findPhones()%>" varStatus="status">
					<tr>
						<td align="center">${status.count }</td>
						<td align="center">${phone.getPhonename() }</td>
						<td align="center">${phone.getPrice() }</td>
						<%--${pageContext.request.contextPath}/AlterPhoneServlet?phonename=${phone.getPhonename()}&sty=less --%>
						<td align="center"><a class="carta" id="del"
							href="${pageContext.request.contextPath}/AlterPhoneServlet?phonename=${phone.getPhonename()}&sty=less">&nbsp;<input
								type="button" value="-" />&nbsp;
						</a> ${phone.getNum() } <a class="carta" id="add" onclick="add();"
							href="${pageContext.request.contextPath}/AlterPhoneServlet?phonename=${phone.getPhonename()}&sty=add">&nbsp;<input
								type="button" value="+" />&nbsp;
						</a></td>
						<td align="center"><a class="carta"
							href="AlterMessageServlet?phonename=${phone.getPhonename() }"
							style="color:blue">编辑</a></td>
						<td align="center"><a class="carta" style="color:black"
							href="${pageContext.request.contextPath}/AlterPhoneServlet?phonename=${phone.getPhonename()}&sty=del">X</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<div>
		<%@include file="foot.jsp"%>
	</div>
</body>
</html>
