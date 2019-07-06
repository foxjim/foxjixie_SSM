<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.hnist.model.AdminUser" %>
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
<!-- jQuery -->
<script src="js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->
<script type="text/javascript" src="../js/register.js"></script>
<script type="text/javascript" src="./js/user.js"></script>
<script type="text/javascript" src="../js/formcommonJs.js"></script>
<link type="text/css" rel="stylesheet" href="../js/formcommonCss.css">

<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->

<style>
        #upFile {
            position: relative;
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
            cursor: pointer;
            font-weight:200;
        }
        /*隐藏默认样式*/
        input[id=file] {
            margin-left: -2000px;
            height: 0;
        }
    </style>

</head> 
<body>
	<!-- from 弹框 -->

	<div class="ui-mask" id="mask" onselectstart="return false"></div>

	<div class="ui-dialog" id="dialogMove" onselectstart='return false;'>

		<div class="ui-dialog-title" id="dialogDrag"
			onselectstart="return false;">
			上传文件（仅支持.xlsx和.xls） <a class="ui-dialog-closebutton"
				href="javascript:hideDialog();">X</a>
		</div>

		<div class="ui-dialog-content">

			<div>
				<label for="file" id="upFile"><span id="fileName">点击此处上传文件</span></label> 
				
					<input type="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" id="file">
					
			</div>
			<br>
			
			<div>
				<a href="./img/User模板.xlsx">点击下载xlsx文件模板</a><br>
				<a href="./img/User模板.xls">点击下载xls文件模板</a>
			</div>
			<br>
			<div>
				<a class="ui-dialog-submit" href="javascript:void(0)" onclick="InsertUserByExcel()">确定上传</a>
			</div>
			<script>
        $("#file").on("change", function () {
            //截取路径，获取上传文件名
            var urlArr = this.value.split("\\");
            if (this && this.files && this.files[0]) {
                document.getElementById("fileName").innerHTML = urlArr[urlArr.length - 1];
                var fileUrl = URL.createObjectURL(this.files[0]);
                //document.getElementById("fileImg").src = fileUrl;
            } else {
                //兼容IE9以下
                document.getElementById("fileName").innerHTML = urlArr[urlArr.length - 1];
            }
            
            if(document.getElementById("fileName").innerHTML.length<=0){
            	document.getElementById("fileName").innerHTML='点击此处上传文件'
            }
        });
    </script>
		</div>

	</div>

	<div class="ui-mask" id="mask"></div>
	<!-- from 弹框 -->


	<div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
               <!--header start here-->
				<%@ include file="./head_common.jsp" %>
<!--heder end here-->
<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">计协会员管理</a><i class="fa fa-angle-right"></i>添加计协会员</li> <li style="float:right;cursor:pointer;" onclick="showDialog()">批量添加</li>
            </ol>
<!--grid-->
	 		
	
 	<div class="validation-system">
 	

 		
 		<div class="validation-form">
 
 		<span style="color:red;">${loginError }</span>
  	   
        <form action="InsertUser" method="post">
             
             
            
            <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">学号</label>
              <input type="text" placeholder="学号" required="required" id="userNo" name="userNo" >
            </div>
             <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">qq号</label>
              <input type="text" placeholder="账号" required="required" id="userCount" name="userCount" >
            </div>
             <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">姓名</label>
              <input type="text" placeholder="姓名" required="required" id="userName" name="userName" >
            </div>
             <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">专业</label>
              <input type="text" placeholder="专业" required="required" id="userCollege" name="userCollege" >
            </div>
             <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">班级</label>
              <input type="text" placeholder="班级" required="required" id="email" name="email" >
            </div>
            <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">密码</label>
              <input type="text" placeholder="密码" required="required" id="userPassword" value="123456" name="userPassword" >
            </div>
             <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">电话号码</label>
              <input type="text" placeholder="电话号码" required="required" id="telPhone" name="telPhone" >
            </div>
             <div class="clearfix"> </div>
	
            <div class="col-md-12 form-group">
              <button type="button" onclick="InertUser()" class="btn btn-primary">提交</button>
              <button type="reset" class="btn btn-default">重置</button>
            </div>
         	 <div class="clearfix"> </div>
          
        </form>
    	
 	
 </div>

</div>
 	<!--//grid-->

<!-- script-for sticky-nav -->
		<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
			 
		});
		</script>
		<!-- /script-for sticky-nav -->
<!--inner block start here-->
<div class="inner-block">

</div>
<!--inner block end here-->
<!--copy rights start here-->
<%@ include file="./footer_common.jsp" %>	
<!--COPY rights end here-->
</div>
</div>
  <!--//content-inner-->
			<!--/sidebar-menu-->
				<%@ include file="./left.jsp" %>
							  <div class="clearfix"></div>		
							</div>
							<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
   <!-- /Bootstrap Core JavaScript -->	   

</body>
<script type="text/javascript">
var dialogInstace , onMoveStartId , mousePos = {x:0,y:0};

function g(id){return document.getElementById(id);}

function autoCenter( el ){

var bodyW = document.documentElement.clientWidth;

var bodyH = document.documentElement.clientHeight;

var elW = el.offsetWidth;

var elH = el.offsetHeight;

el.style.left = (bodyW-elW)/2 + 'px';

el.style.top = (bodyH-elH)/2 + 'px';

}

function fillToBody( el ){

el.style.width  = document.documentElement.clientWidth  +'px';

el.style.height = document.documentElement.clientHeight + 'px';

}

function Dialog( dragId , moveId ){

var instace = {} ;

instace.dragElement  = g(dragId);

instace.moveElement  = g(moveId);

instace.mouseOffsetLeft = 0;

instace.mouseOffsetTop = 0;

instace.dragElement.addEventListener('mousedown',function(e){

var e = e || window.event;

dialogInstace = instace;

instace.mouseOffsetLeft = e.pageX - instace.moveElement.offsetLeft ;

instace.mouseOffsetTop  = e.pageY - instace.moveElement.offsetTop ;

onMoveStartId = setInterval(onMoveStart,10);

return false;

})

return instace;

}

document.onmouseup = function(e){

dialogInstace = false;

clearInterval(onMoveStartId);

}

document.onmousemove = function( e ){

var e = window.event || e;

mousePos.x = e.clientX;

mousePos.y = e.clientY;

e.stopPropagation && e.stopPropagation();

e.cancelBubble = true;

e = this.originalEvent;

        e && ( e.preventDefault ? e.preventDefault() : e.returnValue = false );

        document.body.style.MozUserSelect = 'none';

}

function onMoveStart(){

var instace = dialogInstace;

   if (instace) {   

   	var maxX = document.documentElement.clientWidth -  instace.moveElement.offsetWidth;

   	var maxY = document.documentElement.clientHeight - instace.moveElement.offsetHeight ;

instace.moveElement.style.left = Math.min( Math.max( ( mousePos.x - instace.mouseOffsetLeft) , 0 ) , maxX) + "px";

instace.moveElement.style.top  = Math.min( Math.max( ( mousePos.y - instace.mouseOffsetTop ) , 0 ) , maxY) + "px";

   }

}

function showDialog(){

g('dialogMove').style.display = 'block';

g('mask').style.display = 'block';

autoCenter( g('dialogMove') );

fillToBody( g('mask') );

}

function hideDialog(){

g('dialogMove').style.display = 'none';

g('mask').style.display = 'none';

}

window.onresize = showDialog;

Dialog('dialogDrag','dialogMove');



</script>
</html>