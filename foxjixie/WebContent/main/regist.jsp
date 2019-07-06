<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>fox计协后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="css/morris.css" type="text/css"/>
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery-ui.css"> 
<!-- jQuery -->
<script src="js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->

<script type="text/javascript" src="./js/mainRegister.js"></script>

<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<style type="text/css">
	.showstart{
		float:left;
		width:10%;
		overflower:hidden;
	}
	.main-wthree input.name {
		width: 61%;

	}

	.main-wthree input.password {
		width: 61%;
	
	}
	
	.login-w3 {
   		 margin-right: 10%;
	}
</style>
</head> 
<body>
	<div class="main-wthree">
	<div class="container">
	<div class="sin-w3-agile">
		<h2>fox计协后台注册界面</h2>
		${message }
		<form action="./register.do" method="post" onsubmit="return regis();">
		
			<div class="username">
				<span class="username">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span>
				<input type="text" id="adminName" value="${adminUser.adminName }" name="adminName" readonly="readonly"  class="name" placeholder="姓名" required="required" oninput="ensureAdminName()">
				<p id="adminName_show" class="showstart"></p>
				<div class="clearfix"></div>
			</div>
			
			<div class="username">
				<span class="username">所在部门:</span>
				<input type="text"id="adminDepartment" value="${adminUser.adminDepartment }" name="adminDepartment" readonly="readonly"  class="name" placeholder="部门（宣传部）" required="required" oninput="ensureAdminPosition">
				<p id="adminDepartment_show" class="showstart"></p>
				<div class="clearfix"></div>
			</div>
			
			<div class="username">
				<span class="username">所在职位:</span>
				<input type="text" id="adminPosition" value="${adminUser.adminPosition }" readonly="readonly" name="adminPosition" class="name" placeholder="职位（部长、副部长、其他（不显示））" required="required" oninput="">
				<p id="adminPosition_show" class="showstart"></p>
				<div class="clearfix"></div>
			</div>
			
			<div class="username">
				<span class="username">任届:</span>
				<input type="text" id="adminGrades" value="${adminUser.adminGrades }" readonly="readonly" name="adminGrades" class="name" placeholder="任届（16、17、18）" required="required">
				<p id="adminGrades_show" class="showstart"></p>
				<div class="clearfix"></div>
			</div>
			
			<div class="username">
				<span class="username">电话号码:</span>
				<input type="text" id="adminPhoneNumber" value="${adminUser.adminPhoneNumber }" readonly="readonly" name="adminPhoneNumber" class="name" placeholder="电话号码" required="required" oninput="ensureTelPhone()">
				<p id="adminPhoneNumber_show" class="showstart"></p>
				<div class="clearfix"></div>
			</div>
			
			
			<div class="password-agileits">	
				<span class="username">使用密码:</span>
				<input id="userPassword" type="password"  readonly="readonly" name="adminPassword" class="password"  required="required" oninput="ensurePassword()">
				<p id="pwd1_show" class="showstart"></p>
				<div class="clearfix"></div>
			</div>
			
			<div class="password-agileits">
				<span class="username">确认密码:</span>
				<input id="pwd2" type="password" class="password" readonly="readonly"  required="required" oninput="ensurePwd2()">
				<p id="pwd2_show" class="showstart"></p>
				<div class="clearfix"></div>
			</div>
			
			<div class="login-w3">
					<input type="submit" class="login" value="注   册 ">
			</div>
			
			<div class="clearfix"></div>
		</form>
		<div class="back">
						<a href="./login.jsp">返回登陆</a>
				</div>
				<div class="footer">
					<p>Copyright &copy; 2018.Company name All rights .<a target="_blank" href="http://120.79.216.201">计算机协会</a></p>
				</div>
	</div>
	</div>
	</div>

</body>
<script type="text/javascript">
//去除readonly
setTimeout(function removeReadonly(){
	var input=document.getElementsByTagName('input');
	for(let i=0;i<input.length;i++){
		input[i].removeAttribute("readonly")
	}
},1000)
</script>
</html>