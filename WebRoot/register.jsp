<%@page import="zzy.phoneStore.bean.UserBean"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
  
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		.first h3{
			text-align: center;
			letter-spacing:3px;
			font-size: 30px;
		}
		.register{
			margin-left: 510px;
		}
		.oneone{
			text-align: right;
		}
		.register .one td{
			padding-top: 15px;
		}
		.two{
			margin-left: 70px;
			margin-top: 10px;
		}
		.three{
			margin-left: 70px;
			margin-top: 15px;
		}
		.threeone{
			padding-left: 25px;
		}
	</style>
	<script type="text/javascript">
		function reloadCode(){
			var time = new Date().getTime();
			document.getElementById("image").src="<%=request.getContextPath()%>/CheckServlet?id="+time;
		}
	</script>
  </head>
  
  <body>
  	<%@include file="head.jsp" %>
  	<%@include file="menu.jsp" %>
  	<%
  		UserBean user = (UserBean)request.getSession().getAttribute("user");
  		String[] str = {"用户名不能为空！！！","用户名已存在！！！","密码不能为空！！！","两次密码不一致！！！","验证码不正确！！！"};
  		if(request.getSession().getAttribute("error")!=null){
	  		String error = request.getSession().getAttribute("error").toString();
	  		int index = Integer.parseInt(error.trim())-1;
	  		if(!error.trim().equals("")){
  	%>
  	<script>
  			setTimeout("alert('<%=str[index]%>')", 100 )
  	</script>
  	<%		
  		  	}
  		  	request.getSession().removeAttribute("error");
  		}
  	 %>
  	<div id="content">
	  	<div class="first">
	  		<h3>欢迎用户进行注册</h3>
	  	</div>
	  	<div class="register">
	    	<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
	    		<table class="one">
	    			<tr>
	    				<td class="oneone">用户名：</td>
	    				<td><input type="text" name="username" value="${user.getUsername()}"/></td>
	    			</tr>
	    			<tr>
	    				<td class="oneone">密码：</td>
	    				<td><input type="password" name="password" value="${user.getPassword()}"/></td>
	    			</tr>
	    			<tr>
	    				<td class="oneone">确认密码：</td>
	    				<td><input type="password" name="password2" value="${user.getPassword2()}"/></td>
	    			</tr>
	    			<tr>
	    				<td class="oneone">邮箱：</td>
	    				<td><input type="text" name="email" value="${user.getEmail()}"/></td>
	    			</tr>
	    			<tr>
	    				<td class="oneone">手机号：</td>
	    				<td><input type="text" name="phone" value="${user.getPhone()}"/></td>
	    			</tr>
	    			<tr>
	    				<td class="oneone">地址：</td>
	    				<td><input type="text" name="address" value="${user.getAddress()}"/></td>
	    			</tr>
		  			<tr>
			  			<td class="oneone">验证码：</td>
			  			<td><input type="text" name="verfi" style="width: 80px"/></td>
		  			</tr>	
		  		</table>
	  			<table class="two">	
		  			<tr>
		  	  			<td class="twoone"><img id="image" src="<%=request.getContextPath()%>/CheckServlet" style="margin-left: 20px" ></td>
			  			<td><a href="javascript:reloadCode();" style="color:blue">&nbsp;看不清，换一张</a></td>
		  			</tr>
		  		</table>
		  		<table class="three">
		  			<tr>
		  				<td class="threeone"><a href="head.jsp"><input type="submit" value="确认并登陆" style="height: 30px; width: 80px"/></a></td>
		  			</tr>
	  			</table>
	  		</form>
	  	</div>
  	</div>
	<div>
		<%@include file="foot.jsp" %>
	</div>
  </body>
</html>
