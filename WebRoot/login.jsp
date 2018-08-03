<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆界面</title>
    
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
			margin-top: 50px;
		}
		.login{
			margin-top: 35px;
			margin-left: 510px;
		}
		.oneone{
			text-align: right;
		}
		.login .one td{
			padding-top: 15px;
		}
		.two{
			margin-left: 50px;
			margin-top: 10px;
		}
		.three{
			margin-left: 45px;
			margin-top: 20px;
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
  	<div class="first">
  		<h3>欢迎用户登陆</h3>
  	</div>
  	<div class="login">
	<%
  		UserBean user = (UserBean)request.getSession().getAttribute("user");
  		String[] str = {"用户名不能为空！！！","密码不能为空！！！","验证码不正确！！！","用户名不存在！！！","密码错误！！！"};
  		if(request.getSession().getAttribute("loginerror")!=null){
	  		String loginerror = request.getSession().getAttribute("loginerror").toString();
	  		int index = Integer.parseInt(loginerror.trim())-1;
	  		if(!loginerror.trim().equals("")){
  	%>
  	<script>
  		setTimeout("alert('<%=str[index]%>')", 100 )
  	</script>
  	<%		
  		  	}
  		  	request.getSession().removeAttribute("loginerror");
  		}
  	%>
    	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
    		<table class="one">
    			<tr>
    				<td class="oneone">用户名：</td>
    				<td><input type="text" name="username" value="${user.getUsername() }"/></td>
    			</tr>
    			<tr>
    				<td class="oneone">密码：</td>
    				<td><input type="password" name="password" value="${user.getPassword() }"/></td>
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
	  				<td class="threeone"><a href="head.jsp"><input type="submit" value="登陆" style="height: 30px; width: 50px"/></a></td>
	  				<td class="threeone"><a href="register.jsp"><input type="button" value="注册" style="height: 30px; width: 50px"/></a></td>
	  			</tr>
  			</table>
  		</form>
  	</div>
	<div>
		<%@include file="foot.jsp" %>
	</div>
  </body>
</html>
