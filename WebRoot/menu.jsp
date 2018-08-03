<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="zzy.phoneStore.servlet.*"%>
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
		#menu{
			margin-left: 290px;
			margin-top: 10px;
		}
		.menuone{
			color: black;
			margin-left: 80px;
		}
		.menucolor{
			color: black;
		}
		#seartchmain{
			margin-left: 850px;
			margin-top: 20px;
		}
	</style>
  </head>
  
  <body>
	<div id="menu">
	    <a  href="main.jsp" class="menuone">首页</a>
		<a  href="every.jsp?method=apple&name=苹果" class="menuone">苹果</a>
		<a  href="every.jsp?method=oppo&name=oppo" class="menuone">oppo</a>
		<a  href="every.jsp?method=vivo&name=vivo" class="menuone">vivo</a>
		<a  href="every.jsp?method=gionee&name=金立" class="menuone">金立</a>
		<a  href="every.jsp?method=huawei&name=华为" class="menuone">华为</a>
	</div>
  </body>
</html>
