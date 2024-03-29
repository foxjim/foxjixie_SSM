/**
 *
 *关于注册所用的js(包括管理员添加会员)
 *
 **/

let userNozz=1;
/**
 * 验证学号的方法
 * @author Liuyun 2019/05/27
 */
function ensureUserNo(){
	var userNo=document.getElementById("userNo");
	var userNo_show=document.getElementById("userNo_show");
	
	if(userNo.value.length<6){
		userNo_show.innerHTML='学号不少于6位数';
		userNozz=1;
	}else if(userNo.value.length>=32){
		userNo_show.innerHTML='学号不大于32位数';
		userNozz=1;
	}else{
		
		$.ajax({
			  url: "./existByUserNo.do",
			  type:'POST',   
			  data: {
			    userNo:userNo.value
			  },
			  success: function( result ) {
				 
				  
				  if(result=='0'){
					  userNo_show.innerHTML='√';
					  userNozz=0;
					 
				  }else if(result=='1'){
					  userNo_show.innerHTML='学号已注册';
					  userNozz=1;
					
				  }else if(result=='error'){
					  userNo_show.innerHTML='服务器错误';
					  userNozz=1;
					
				  }else{
					  userNo_show.innerHTML='未知错误';
					  userNozz=1;
				  }
			  },
			  error:function(){
				  userNo_show.innerHTML='程序错误';
				  userNozz=1;
			  }
			});
		
	}
}

let userCountzz=1;
/**
 * 验证qq号的方法-原来是账号
 * @author Liuyun 2019/05/27
 * 
 */
function ensureUserCount(){
	var userCount=document.getElementById('userCount');
	var userCount_show=document.getElementById('userCount_show');
	
	if(userCount.value.length<2){
		userCount_show.innerHTML='QQ号不小于两位数';
		userCountzz=1;
	}else if(isNaN(userCount.value)){
		userCount_show.innerHTML='QQ号全是数字把';
		userCountzz=1;
	}else if(userCount.value.length>12){
		userCount_show.innerHTML='QQ号不超过12个数字';
		userCountzz=1;
	}else{
		$.ajax({
			url:'./existByUserCount.do',
			type:'POST',
			data:{
				userCount:userCount.value
			},
			success:function(result){
				  if(result=='0'){
					  userCount_show.innerHTML='√';
					  userCountzz=0;
					 
				  }else if(result=='1'){
					  userCount_show.innerHTML='QQ号已注册';
					  userCountzz=1;
					
				  }else if(result=='error'){
					  userCount_show.innerHTML='服务器错误';
					  userCountzz=1;
					
				  }else{
					  userCount_show.innerHTML='未知错误';
					  userCountzz=1;
				  }
			},
			error:function(){
				 userCount_show.innerHTML='程序错误';
				  userCountzz=1;
			}
		})
	}
}


let userNamezz=1;
/**
 * 确认姓名的方法
 * @author Liuyun 2019/05/27
 * 
 */
function ensureUserName(){
	var userName=document.getElementById('userName');
	var userName_show=document.getElementById('userName_show');
	
	//单词字符
	var regNS=/\w+/;
	
	if(userName.value.length<2){
		userName_show.innerHTML='姓名太短'
		userNamezz=1;
	}else if(regNS.test(userName.value)){
		userName_show.innerHTML='姓名格式错误'
		userNamezz=1;
	}else if(userName.value.length>=16){
		userName_show.innerHTML='姓名太长'
		userNamezz=1;
	}else{
		userName_show.innerHTML='√'
		userNamezz=0;
	}
	
}


let userCollegezz=1;
/**
 * 确定学院文本框
 * @author Liuyun 2019/05/28
 * 
 */
function ensureCollege(){

	var userCollege=document.getElementById('userCollege');


	var userCollege_show=document.getElementById('userCollege_show');
	
	if(userCollege.value.length<=0){
		userCollegezz=1;
	}else{
		userCollegezz=0;
		userCollege_show.innerHTML='√';
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


let telPhonezz=1;
/**
 * 确认电话号码
 * @author Liuyun 2019/05/28
 */
function ensureTel(){
	var tel=document.getElementById('tel');
	var tel_show=document.getElementById('tel_show');
	
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

let usergradeszz=1;
/**
 * 确认年级
 * @author Liuyun 2019/05/28
 */
function ensureUserGrades(){
	var userGrades=document.getElementById('userGrades');
	var userGrades_show=document.getElementById('userGrades_show');
	
	if(userGrades.value.length<=0){
		usergradeszz=1;
	}else{
		usergradeszz=0;
		userGrades_show.innerHTML='√';
	}
}

let emailzz=1;
/**
 * 确认邮箱_现在是班级了
 * @author Liuyun 2019/05/28
 */
function ensureEmail(){
	var email=document.getElementById('email');
	var email_show=document.getElementById('email_show');
	
	// var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	
	
//	if(!reg.test(email.value)){
//		email_show.innerHTML='邮箱格式不正确';
//		emailzz=1;
//	}
	
	
	if(email.value.length<4){
		email_show.innerHTML='班级需要长一丢丢';
		emailzz=1;
	}else if(email.value.length>20){
		email_show.innerHTML='班级可能太长了';
		emailzz=1;
	}else{
		email_show.innerHTML='√';
		emailzz=0;
//		$.ajax({
//			url:'./existByEmail.do',
//			type:'POST',
//			data:{
//				email:email.value
//			},
//			success:function(result){
//				if(result=='0'){
//					email_show.innerHTML='√';
//					emailzz=0;
//				}else if(result=='1'){
//					email_show.innerHTML='已注册';
//					emailzz=1;
//				}else if(result=='error'){
//					email_show.innerHTML='服务器访问错误';
//					emailzz=1;
//				}else{
//					email_show.innerHTML='未知错误';
//					emailzz=1;
//				}
//			},
//			error:function(){
//				email_show.innerHTML='程序错误';
//				emailzz=1;
//			}
//		})
	}
}

/**
 * 提交表单
 * @author Liuyun 2019/05/28
 * 
 */
function regis(){
	
	if(userNozz==1){
		window.confirm('请检查学号是否正确');
		return false;
	}else if(userCountzz==1){
		window.confirm('请检查QQ号是否正确');
		return false;
	}else if(userNamezz==1){
		window.confirm('请检查姓名是否正确');
		return false;
	}else if(userCountzz==1){
		window.confirm('请检查学号是否正确');
		return false;
	}else if(userCollegezz==1){
		window.confirm('请检查学院是否正确');
		return false;
	}else if(userPasswordzz==1){
		window.confirm('请检查密码是否正确');
		return false;
	}else if(telPhonezz==1){
		window.confirm('请检查电话号码是否正确');
		return false;
	}else if(usergradeszz==1){
		window.confirm('请检查年级是否正确');
		return false;
	}else if(emailzz==1){
		window.confirm('请检查班级填写是否正确');
		return false;
	}else{
		return true;
	}	
}

//json字符转换
function strToJson(str){ 
	var json = eval('(' + str + ')'); 
	return json; 
} 

/**
 * 添加社团成员的方法
 * @returns
 */
function InertUser(){
	var userNo=$('#userNo').val();
	var userCount=$('#userCount').val();
	var userName=$('#userName').val();
	var userCollege=$('#userCollege').val();
	var email=$('#email').val();
	var userPassword=$('#userPassword').val();
	var telPhone=$('#telPhone').val();
	
	var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;//验证电话号码
	var number=/^\+?[1-9][0-9]*$/;
	
	if(userNo.length<=5 || !number.test(userNo)){
		window.confirm('学号太短或者非数字')
	}else if(userCount.length<=5 || !number.test(userCount)){
		window.confirm('QQ号太短或者非数字')
	}else if(userName.length<=1 ){
		window.confirm('姓名有丢丢短了')
	}else if(userCollege.length<0){
		window.confirm('专业有丢丢短了')
	}else if(email.length<3){
		window.confirm('班级有丢丢短了')
	}else if(userPassword.length<=5){
		window.confirm('密码有丢丢短了')
	}else if(!myreg.test(telPhone)){
		window.confirm('电话号码格式不对了')
	}else{
		$.ajax({
			url:'./InsertUser.do',
			type:'POST',
			data:{
				userNo:userNo,
				userCount:userCount,
				userName:userName,
				userPassword:userPassword,
				userCollege:userCollege,
				telPhone:telPhone,
				email:email
			},
			success:function(result){
				
				if(result==0){
					window.confirm('添加成功')
					location.reload();
				}else if(result==1){
					window.confirm('请检查各项表单的正确性')
				}else if(result=='rt'){
					window.confirm('请先登录')
					window.location.href='./login.jsp'
				}else{
					window.confirm('未知错误！请刷新后重试')
				}
			},
			error:function(){
				window.confirm('后台服务连接错误')
			}
		})
	}
}

function login(){
	var userNo=document.getElementById('userNo').value;
	var userPassword=document.getElementById('userPassword').value;
	
	if(userNo.length<=0){
		window.confirm('账号不为空')
	}else if(userPassword.length<=0){
		window.confirm('密码不为空')
	}else{
		$.ajax({
			url:'./login.do',
			type:'POST',
			data:{
				userCount:userNo,
				userPassword:userPassword
			},
			success:function(result){
				if(result==0){
					location.reload();
				}else if(result==1){
					window.confirm('账号或密码错误')
				}else{
					window.confirm('未知错误！请稍后重试3')
				}
			},
			error:function(){
				window.confirm('后台服务连接失败')
			}
		})
	}
}

