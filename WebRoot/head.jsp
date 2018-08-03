<%@page import="zzy.phoneStore.dao.UserDao"%>
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
  <style type="text/css">
  	#hh{
  		text-align: right;
  		margin-right: 250px;
  		margin-top: 20px;
  	}
  	.image{
  		margin-left: 250px;
  	}
  	a:link {
		text-decoration: none;
	}
	a:visited {
		text-decoration: none;
	}
	a:hover {
		text-decoration: underline;
	}
	.head{
		color: black;
	}
  </style>
  </head>
  
  <body>
    <div id="hh">
    	<a class="head" href="cart.jsp">购物车</a>
   	<%
    	if(request.getSession().getAttribute("success")==null||request.getSession().getAttribute("user")==null){
    %>
    	<a class="head" href="${pageContext.request.contextPath}/login.jsp">登陆</a>
    	<a class="head" href="${pageContext.request.contextPath}/register.jsp">注册</a>
    <%
    	}
    	else{	
    		if(request.getSession().getAttribute("user")!=null){
				UserBean user = (UserBean)request.getSession().getAttribute("user");
				user = UserDao.findUser(user.getUsername());
     %>
     	欢迎您！${user.getUsername() }
     	<a class="head" href="main.jsp?style=out">登出</a><br>
     <%			
     			if(user.getId().equals("manager")){
     %>
     		<a class="head" href="backcontrol.jsp">后台管理</a>
     <%
     			}
         	}
     	}
      %>
    </div>
    <div>	
    	<img src="images/head.png" class="image">
    </div>
  </body>
</html>
