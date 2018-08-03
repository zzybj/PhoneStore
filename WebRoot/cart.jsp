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

<title>购物车</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
#carttable {
	margin-left: 360px;
	margin-top: 50px;
}

.firstname {
	width: 125px;
	align: center;
}

#sumprice {
	margin-left: 900px;
	margin-top: 20px;
}

#sub {
	margin-left: 930px;
	margin-top: 10px;
}

.carta {
	color: black;
}
</style>
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
	<%
		String username = "";
		if(request.getSession().getAttribute("user")!=null){
			UserBean userBean = (UserBean)request.getSession().getAttribute("user");
			username = userBean.getUsername();
		}
	 %>
	<div id="cartcontent">
		<form action="${pageContext.request.contextPath}/AlterCartServlet">
			<table id="carttable" border="1" cellspacing="0">
				<tr>
					<th class="firstname">序号</th>
					<th class="firstname">商品名称</th>
					<th class="firstname">商品单价</th>
					<th class="firstname">数量</th>
					<th class="firstname">删除</th>
				</tr>
				<c:forEach var="phone" items="<%=CartDao.findPhone(username,1) %>"
					varStatus="status">
					<tr>
						<td align="center">${status.count }</td>
						<td align="center">${phone.getPhonename() }</td>
						<td align="center">${phone.getPrice() }</td>
						<td align="center"><a class="carta"
							href="${pageContext.request.contextPath}/AlterCartServlet?phonename=${phone.getPhonename()}&sty=less">&nbsp;<input type="button" value="-"/>&nbsp;</a>
							${phone.getNum() } <a class="carta"
							href="${pageContext.request.contextPath}/AlterCartServlet?phonename=${phone.getPhonename()}&sty=add">&nbsp;<input type="button" value="+"/>&nbsp;</a>
						</td>
						<td align="center"><a class="carta"
							href="${pageContext.request.contextPath}/AlterCartServlet?phonename=${phone.getPhonename()}&sty=del">X</a></td>
					</tr>
				</c:forEach>
			</table>
			<%
	  			double sum=0.0;
	  			List<CartBean> cbs = CartDao.findPhone(username,1);
	  			for(CartBean cb:cbs){
	  				sum = sum + cb.getPrice()*cb.getNum();
	  			}
	  		 %>
			<table id="sumprice">
				<tr>
					<td><p>
							总价:<%=sum%></p></td>
				</tr>
			</table>
			<table id="sub">
				<tr>
					<td><a href="${pageContext.request.contextPath}/order.jsp"><input type="button" value="结算" /></a></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<%@include file="foot.jsp"%>
	</div>
</body>
</html>
