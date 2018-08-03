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
	margin-left: 450px;
	margin-top: 50px;
}

.firstname {
	width: 125px;
	align: center;
}

#sumprice {
	margin-left: 875px;
	margin-top: 20px;
}

#sub {
	margin-left: 900px;
	margin-top: 10px;
}
#address{
	margin-left:445px;
	margin-top:20px;
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
		UserBean userBean = null;
		if(request.getSession().getAttribute("user")!=null){
			userBean = (UserBean)request.getSession().getAttribute("user");
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
				</tr>
				<c:forEach var="phone" items="<%=CartDao.findPhone(username,1) %>"
					varStatus="status">
					<tr>
						<td align="center">${status.count }</td>
						<td align="center">${phone.getPhonename() }</td>
						<td align="center">${phone.getPrice() }</td>
						<td align="center">${phone.getNum() }</td>
					</tr>
				</c:forEach>
			</table>
			<%
	  			double sum=0.0;
	  			List<CartBean> cbs = CartDao.findPhone(username, 1);
	  			for(CartBean cb:cbs){
	  				sum = sum + cb.getPrice()*cb.getNum();
	  			}
	  		 %>
	  		 <%
	  		 	UserBean ub = UserDao.findUser(username);
	  		  %>
	  		<table id="address">
	  			<tr>
	  				<td>
	  					<p>收货人：<%=ub.getUsername()%></p>
	  					<p>收货地址：<%=ub.getAddress()%></p>
	  					<p>联系方式：<%=ub.getPhone()%></p>
	  				</td>
	  			</tr>
	  		</table>
			<table id="sumprice">
				<tr>
					<td><p>
							总价:<%=sum%></p></td>
				</tr>
			</table>
		</form>
		<table id="sub">
			<tr>
				<td><input type="button" value="生成订单" /></td>
			</tr>
		</table>
	</div>
	<div>
		<%@include file="foot.jsp"%>
	</div>
</body>
</html>
