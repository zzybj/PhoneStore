<%@page import="java.io.InputStream"%>
<%@page import="com.sun.mail.imap.protocol.Status"%>
<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@page import="java.sql.ResultSet"%>
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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><%=new String(request.getParameter("name").getBytes("iso8859-1"),"UTF-8") %>手机</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
#maincontent {
	margin-left: 270px;
	margin-right: 250px;
	margin-top: 20px;
}

#main {
	position: relative;
}

.box {
	padding: 15px 0 0 15px;
	float: left;
}

.pic {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-shadow: 0 0 5px #ccc;
}

.pic img {
	width: 165px;
	height: auto;
}

.price {
	margin-top: 10px;
}

.phonename {
	margin-top: 10px;
}

</style>
</head>

<body>
	<%@include file="head.jsp"%>
	<%@include file="menu.jsp"%>
	<%@include file="searchbar.jsp"%>
	<%
		String method = request.getParameter("method");
	 %>
	<div id="maincontent">
	  	<c:forEach var="phone" items="<%=PhoneDao.findPhones(method) %>">
		    <div class="box"> 
				<div class="pic">
					<a href="single.jsp?address=${phone.getAddress()}&method=<%=method%>"><img src="images/<%=method %>/${phone.getAddress()}.jpg"></a>	
				</div>
				<div class="price">¥${phone.getPrice() }</div>
				<div class="phonename">
					<a href="single.jsp?address=${phone.getAddress()}&method=<%=method%>" style="color:blue">${phone.getPhonename() }</a>
				</div>
			</div>
	    </c:forEach> 
	</div> 
	<div>
		<%@include file="foot.jsp"%>
	</div>
</body>
</html>
