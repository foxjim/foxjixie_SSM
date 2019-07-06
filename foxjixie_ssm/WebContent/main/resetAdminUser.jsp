<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title>fox计协后台管理系统</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="./main/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="./main/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="./st/ss/morris.css" type="text/css"/>
<!-- Graph CSS -->
<link href="./main/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery-ui.css"> 
<!-- jQuery -->
<script src="./main/js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->

<link rel="stylesheet" href="./main/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head> 
<body>
	<div class="main-wthree">
	<div class="container">
	<div class="sin-w3-agile">
		<h2>fox计协后台重置密码界面</h2>
		${message}
		<form action="/foxjixie/main/Password.do" method="post" onsubmit="return regis();">
	
		<input type="hidden" name="userId" value="${userId}">
		
		
			<div class="username">
				<span class="username">密码:</span>
				<input id="pwd" required="required"  type="password" name="userPassword" class="name" >
				<div class="clearfix"></div>
			</div>
			<div class="password-agileits">
				<span class="username">确定密码:</span>
				<input id="pwd2" required="required" type="password" class="password" >
				<div class="clearfix"></div>
			</div>
			
			<div class="login-w3">
					<input type="submit" class="login" value="更改完成">
			</div>
			<div class="clearfix"></div>
		</form>
				<div class="back">
					<a href="./main/login.jsp">返回登陆界面</a>
				</div>
				<div class="footer">
					<p>Copyright &copy; 2018.Company name All rights.<a target="_blank" href="http://120.79.216.201">计算机协会</a></p>
				</div>
	</div>
	</div>
	</div>
  </body>
  

<script>
	function regis() {
		
		var pwd = document.getElementById("pwd").value;
		var pwd2 = document.getElementById("pwd2").value;
		if (pwd !== pwd2) {
			alert('密码前后不一致！');
			return false;
		}
		return true;
	}
</script>
<!-- //验证输入的信息是否合法 -->
</html>