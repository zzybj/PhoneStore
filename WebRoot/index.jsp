<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">  
        function reImg(){  
            var img = document.getElementById("Img");  
            img.src = "Img?rnd=" + Math.random();  
        }  
    </script>  
  </head>
  
  <body>
  	<!--   	<img id="Img" src="Img" alt="验证码"  />  -->
    <center>  
        <img id="Img" src="${pageContext.request.contextPath }/CheckServlet" alt="验证码"  />  
        <a href="index.jsp" onclick="reImg();">看不清，换一张</a>  
    </center>  
  </body>
</html>
