<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma"  content="no-cache" > 
<meta http-equiv="Cache-Control"   content="no-cache" > 
<meta http-equiv="Expires"   content="0" > 

<title>注册-计协会员</title>
<link rel="stylesheet" href="./front/CSS/mr-01.css" type="text/css">
<script type="text/javascript" src="./js/register.js"></script>

<style type="text/css">

	
	.register_select{
		    display: block;
		    float: left;
    		width: 74%;
   			height: 43px;
    		padding: 6px 12px;
    		font-size: 12px;
    		line-height: 1.666667;
    		color: #555555;
   		 	background-color: #ffffff;
    		background-image: none;
    		border: 1px solid #cccccc;
    		border-radius: 0;
		
	
	
	}
	
	.star{
		font-size:10px; 
		color:red;
	}
</style>


</head>

<body style="text-align: center;background-image: url(./front/img/login_bases10.jpg); background-repeat: no-repeat;background-size: cover;">
	<!-- 主体内容 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<div id="mr-content" class="mr-content col-xs-12">
				<div class="login-wrap" style="margin-bottom: 60px; margin-top: 50px">
					<div style="max-width: 540px; margin: 0 auto;">
						<a href="index.jsp" title="点击返回首页"><img src=""></a>
					</div>
					<div class="login" style=" background-color: rgba(236, 234, 234, 0.819);">
						<div class="page-header" style="pause: 0px;">
							<h1 class="login_h1">会员注册</h1>
							<p style="color:red;">${loginError}</p>
						</div>
						<!-- 会员注册表单 -->
						<form id="member-registration" action="./register.do"  autocomplete="off"
							onsubmit="return regis();" method="post" class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="username-lbl" for="username" class="required">
											学号 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 学号文本框 -->
										<input type="text" name="userNo" id="userNo" class="required"
											size="38" required="required" oninput="ensureUserNo()" readonly="readonly">
											<span id="userNo_show" class="star">&nbsp;*</span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="username-lbl" for="userCount" class="required">
											账号：</label>
									</div>
									<div class="col-sm-8">
										<!-- 账户文本框 -->
										<input type="text" name="userCount" id="userCount" value=""readonly="readonly"
											class="required" size="38" required="required" oninput="ensureUserCount()">
										
										<span id="userCount_show" class="star">&nbsp;*</span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											真实姓名 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 真实姓名文本框 -->
										<input type="text" name="userName" id="userName" oninput="ensureUserName()" 
											class="validate-username required" size="38" required="required"   readonly="readonly">
										
										<span id="userName_show" class="star">&nbsp;*</span>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											学院 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 学院文本框 -->
										<select name="userCollege" id="userCollege" class="register_select" required="required" oninput="ensureCollege()">
											<option selected disabled value="">----请选择学院----</option>
										</select>
										<span id="userCollege_show"  class="star">&nbsp;*</span>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											密码 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 密码文本框 -->
										<input type="password" name="userPassword" id="userPassword" oninput="ensurePassword()"
											autocomplete="off" class="validate-password required" readonly="readonly"
											size="38" maxlength="99" required="required">
											<span id="pwd1_show" class="star">&nbsp;*</span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											确认密码 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 确认密码文本框 -->
										<input type="password" name="pwd2" id="pwd2" oninput="ensurePwd2()"
											autocomplete="off" class="validate-password required" readonly="readonly"
											size="38" maxlength="99" required="required" >
										<span  id="pwd2_show"  class="star">&nbsp;*</span>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											联系电话 ：</label>
									</div>
									<div class="col-sm-8" >
										<!-- 联系电话文本框 -->
										<input type="text" name="telPhone" class="validate-password required " id="tel" readonly="readonly" oninput="ensureTel()"
											value="" size="38" aria-required="true">
										
											<span  id="tel_show"  class="star">&nbsp;*</span>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											年级 ：</label>
									</div>
									<div class="col-sm-8">
										<select name="userGrades" id="userGrades" class="register_select" oninput="ensureUserGrades()">
											<option selected disabled value="">----请选择年级----</option>
									
										</select>
										<span id="userGrades_show"  class="star">&nbsp;*</span>
									
									</div>
								</div>
								
								
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											邮箱 ：</label>
									</div>
									<div class="col-sm-8" style="clear: none;">
										<!-- 邮箱文本框 -->
										<input type="email" name="email" class="validate-password required " readonly="readonly" oninput="ensureEmail()"
											id="email" value="" size="38" aria-required="true">
											
										<span  id="email_show"  class="star">&nbsp;*</span>
									</div>
								</div>
								<div class="form-group">
									<div style="float: right; padding-right: 160px;">
										计协会员<a href="./front/tiaokuan.jsp" target="_blank"  style="color: #0885B1;">《使用条款》</a>
									</div>
								</div>
								
								
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-8">
										<button type="submit" class="btn btn-primary login">同意协议并注册</button>
									</div>
								</div>
								
								&nbsp;
								<div class="form-group" style="margin: 20px;">
									<label
										style="float: right; color: #858585; margin-right: 80px; margin-top: 10px; font-size: 14px;">已有账号！<a
										href="login.jsp">去登录</a></label>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //主体内容 -->
</body>

<script src="./front/js2/jquery.1.3.2.js" type="text/javascript"></script>

<!-- 显示年级和学院 -->
<script type="text/javascript">
	
	//从后台获取所有学院显示在select下拉列表
	(function earnUserCollege(){
		var userCollege=document.getElementById('userCollege');
		
		$.ajax({
			url:'./findAllCollege.do',
			type:'POST',
			success:function(result){
				var colleges=strToJson(result);
				for(var i in colleges){
					var option=userCollege.appendChild(document.createElement('option'));
					option.value=colleges[i].collegeNo;
					option.innerHTML=colleges[i].collegeName;
				}
			},
			error:function(){
				window.confirm('服务器错误,请刷新或稍后重试');
			}
		})
	})();
	
	//给年级下拉列表赋值
	(function earnUserGrades(){
		var date=new Date();
		var grades=date.getFullYear()%100;
		//console.log(grades+'grades');
		var userGrades=document.getElementById('userGrades');
		
		for(var i=0;i<5;i++){
			var option=userGrades.appendChild(document.createElement('option'));
			//console.log(grades-4+i+'zz')
			option.value=grades-4+i;
			option.innerHTML=grades-4+i;
		}
		
	})();
	
	//json字符转换
	function strToJson(str){ 
		var json = eval('(' + str + ')'); 
		return json; 
} 
	
	//去除readonly
	setTimeout(function removeReadonly(){
		var input=document.getElementsByTagName('input');
		for(let i=0;i<input.length;i++){
			input[i].removeAttribute("readonly")
		}
	},1000)

</script>
<!-- 显示年级和学院 -->
</html>