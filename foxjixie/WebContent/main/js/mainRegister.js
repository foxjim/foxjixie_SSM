

adminNamezz=1;
/**
 * 姓名验证
 */
function ensureAdminName(){
	var adminName=document.getElementById('adminName');
	var adminName_show=document.getElementById('adminName_show');
	
	//单词字符
	var regNS=/\w+/;
	
	if(adminName.value.length<2){
		adminName_show.innerHTML='姓名太短'
		adminNamezz=1;
	}else if(regNS.test(adminName.value)){
		adminName_show.innerHTML='姓名格式错误'
		adminNamezz=1;
	}else if(adminName.value.length>=16){
		adminName_show.innerHTML='姓名太长'
		adminNamezz=1;
	}else{
		adminName_show.innerHTML='√'
		adminNamezz=0;
	}
}

adminDepartmentzz=1;
/**
 * 确定所在部门
 */
function ensureAdminDepartment(){
	var adminDepartment=document.getElementById('adminDepartment');
	var adminDepartment_show=document.getElementById('adminDepartment_show');
	
	//单词字符
	var regNS=/\w+/;
	
	if(adminDepartment.value.length<1){
		adminDepartment_show.innerHTML='部门太短'
		adminDepartmentzz=1;
	}else if(regNS.test(adminDepartment.value)){
		adminDepartment_show.innerHTML='部门格式错误'
		adminDepartmentzz=1;
	}else if(adminDepartment.value.length>=16){
		adminDepartment_show.innerHTML='部门太长'
		adminDepartmentzz=1;
	}else{
		adminDepartment_show.innerHTML='√'
		adminDepartmentzz=0;
	}
}


adminPositionzz=1;
/**
 * 确认任职 职位
 */
function ensureAdminPosition(){
	var adminPosition=document.getElementById('adminPosition');
	var adminPosition_show=document.getElementById('adminPosition_show');
	
	//单词字符
	var regNS=/\w+/;
	
	if(adminPosition.value.length<1){
		adminPosition_show.innerHTML=' 职位太短'
			adminPositionzz=1;
	}else if(regNS.test(adminPosition.value)){
		adminPosition_show.innerHTML=' 职位格式错误'
			adminPositionzz=1;
	}else if(adminPosition.value.length>=16){
		adminPosition_show.innerHTML=' 职位太长'
			adminPositionzz=1;
	}else{
		adminPosition_show.innerHTML='√'
			adminPositionzz=0;
	}
}


adminGradeszz=1;
/**
 * 确认任届
 */
function ensureAdminGrades(){
	var adminGrades=document.getElementById('adminGrades');
	var adminGrades_show=document.getElementById('adminGrades_show');
	
	//单词字符
	var regNS=/\w+/;
	
	if(adminGrades.value.length<2){
		adminGrades_show.innerHTML='任届太短'
		adminGradeszz=1;
	}else if(!regNS.test(adminGrades.value)){
		adminGrades_show.innerHTML='任届格式错误'
		adminGradeszz=1;
	}else if(adminGrades.value.length>=16){
		adminGrades_show.innerHTML='任届太长'
		adminGradeszz=1;
	}else{
		adminGrades_show.innerHTML='√'
		adminGradeszz=0;
	}
}

/**
 * 确认电话号码
 */
function ensureTelPhone(){
	var tel=document.getElementById('adminPhoneNumber');
	var tel_show=document.getElementById('adminPhoneNumber_show');
	
	var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
	
	
	if(!myreg.test(tel.value)){
		tel_show.innerHTML='请输入合法的电话号码';
		telPhonezz=1;
	}else{
		$.ajax({
			url:'./existByTelPhone.do',
			type:'POST',
			data:{
				telPhone:tel.value
			},
			success:function(result){
				if(result=='0'){
					tel_show.innerHTML='√';
					telPhonezz=0;
				}else if(result=='1'){
					tel_show.innerHTML='电话号码已注册';
					telPhonezz=1;
				}else if(result=='error'){
					tel_show.innerHTML='服务器访问错误';
					telPhonezz=1;
				}else{
					tel_show.innerHTML='未知错误';
					telPhonezz=1;
				}
			},
			error:function(){
				tel_show.innerHTML='程序错误';
				telPhonezz=1;
			}
		})
	}
}

let userPasswordzz=1;
/**
 * 确定密码文本框
 * @author Liuyun 2019/05/28
 * 
 */
function ensurePassword(){
	
	//获取input 表单
	var pwd1=document.getElementById('userPassword');
	var pwd2=document.getElementById('pwd2');
	
	//显示
	var pwd1_show=document.getElementById('pwd1_show');
	var pwd2_show=document.getElementById('pwd2_show');
	
	if(pwd1.value.length<6){
		pwd1_show.innerHTML='密码不少于6位数';
		userPasswordzz=1;
	}else if(pwd2.value.length>32){
		pwd1_show.innerHTML='密码太长';
		userPasswordzz=1;
	}else if(pwd1.value != pwd2.value){
		pwd1_show.innerHTML='√';
		pwd2_show.innerHTML='请确定密码';
		userPasswordzz=1;
	}
	
	if(pwd1.value == pwd2.value){
		pwd1_show.innerHTML='√';
		pwd2_show.innerHTML='√';
		userPasswordzz=0;
	}
}

/**
 * 确认密码
 * @author Liuyun 2019/05/28 
 */
function ensurePwd2(){
	//获取input 表单
	var pwd1=document.getElementById('userPassword');
	var pwd2=document.getElementById('pwd2');
	
	var pwd2_show=document.getElementById('pwd2_show');
	
	if(pwd1.value != pwd2.value){
		pwd2_show.innerHTML='密码前后不一致';
		userPasswordzz=1;
	}else{
		pwd2_show.innerHTML='√';
		userPasswordzz=0;
	}
}



