<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>fox计协后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="css/morris.css" type="text/css"/>
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet" /> 
<!-- jQuery -->
<script src="js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->
<script type="text/javascript" src="./js/user.js"></script>
<!-- tables -->
<link type="text/css" rel="stylesheet" href="../js/formcommonCss.css"/>
<script type="text/javascript" src="../js/register.js"></script>
<link rel="stylesheet" type="text/css" href="css/table-style.css" />
<link rel="stylesheet" type="text/css" href="css/basictable.css" />
<script type="text/javascript" src="js/jquery.basictable.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
      $('#table').basictable();

      $('#table-breakpoint').basictable({
        breakpoint: 768
      });

      $('#table-swap-axis').basictable({
        swapAxis: true
      });

      $('#table-force-off').basictable({
        forceResponsive: false
      });

      $('#table-no-resize').basictable({
        noResize: true
      });

      $('#table-two-axis').basictable();

      $('#table-max-height').basictable({
        tableWrapper: true
      });
    });
</script>
<!-- //tables -->

<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head> 
<body>

<!-- from 弹框 -->
					
					<div class="ui-mask" id="mask" onselectstart="return false"></div>

					<div class="ui-dialog" id="dialogMove"
						onselectstart='return false;'>

						<div class="ui-dialog-title" id="dialogDrag" onselectstart="return false;">
							批量导出 <a class="ui-dialog-closebutton" href="javascript:hideDialog();">X</a>
						</div>

						<div  class="ui-dialog-content">

							<br/>
							<div>
								<a class="ui-dialog-submit" href="javascript:void(0)" onclick="exportExcel()">导出为xls</a>
							</div>
							<br />
							
							<a id="exprot_excel" ></a>
							

						</div>

					</div>
					
					<div class="ui-mask" id="mask" ></div>
					<!-- from 弹框 -->
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

document.getElementById('exprot_excel').innerHTML=''
}

function hideDialog(){

g('dialogMove').style.display = 'none';

g('mask').style.display = 'none';

}

window.onresize = showDialog;

Dialog('dialogDrag','dialogMove');



</script>
   <div class="page-container">
	 <!--/content-inner-->
	 
	 <!--Start of left-content-->
<div class="left-content">
	   <div class="mother-grid-inner">
            <!--header start here-->
						<%@ include file="./head_common.jsp" %>
<!--heder end here-->
<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">会员管理</a><i class="fa fa-angle-right"></i>社团会员列表</li><li style="float:right;cursor:pointer;" onclick="showDialog()">批量导出</li>
            </ol>
<div class="agile-grids">	
				<!-- tables -->
				
				<div class="agile-tables">
					<div class="w3l-table-info">
					  <h2>社团会员列表管理</h2>
					  
					   
              				<div style="float:right;">
              					<input type="text" placeholder="学号/姓名/专业/QQ号"  name="querymessage" id="querymessage" />
            					<button type="button" onclick="QueryUser()" class="btn btn-primary">查询</button>
             			
              				</div>
              				
					    <table id="table">
						<thead>
						  <tr>
							<th>学号</th>
							<th>QQ号</th>
							<th>姓名</th>
							<th>专业</th>
							<th>班级</th>
							<th>电话号码</th>
							<th>操作</th>
						  </tr>
						</thead>
						<tbody>
						<c:forEach var="u" items="${userss.users}">
						 <tr>
						 	<td>${u.userNo}</td>
						 	<td>${u.userCount}</td>
						 	<td>${u.userName}</td>
						 	<td>${u.userCollege}</td>
						 	<td>${u.email}</td>
						 	<td>${u.telPhone}</td>
						 	<td><a href="javascript:void(0)" onclick="deleteUser('${u.userId}')">删除</a>&nbsp;|&nbsp;<a href="javascript:void(0)" onclick="editUser('${u.userId}')">编辑</a></td>
						 </tr>
						 </c:forEach>
						</tbody>
					  </table>
					  ${message }
					</div>
					
					<div style="margin-top:10px; margin-right:2%;width:100%" class="js">
					<p class="js_left" style="font-size:15px; float:left;">第 <span style="font-color:red;">${userss.currentPage}</span> 页 |
					 共 <span style="font-color:red;">${userss.totalPage}</span> 页 | 
					 共  <span style="font-color:red;">${userss.totalNumber}</span> 条数据&nbsp;&nbsp;&nbsp;&nbsp;</p> 
					
					 
					<a class="js_right"style="float:left;" href="./findAllUser.do?currentPage=1">[首页]&nbsp;&nbsp;</a>
					
					
					<a style="float:left;" href="./findAllUser.do?currentPage=${userss.upPage}">[上一页]&nbsp;&nbsp;</a>
					
				
					<a style="float:left;" href="./findAllUser.do?currentPage=${userss.nextPage}">&nbsp;&nbsp;[下一页]&nbsp;&nbsp;</a>
					
				
					<a style="clear:both;" href="./findAllUser.do?currentPage=${userss.totalPage}">[尾页]</a>
					 
				</div>
				<p style="clear:both;"></p>
			
				 <br />
				 <br />
				 <br />
		
				<form id="form_edit" action="./editUser.do" method="post">
					<input type="hidden"  name="userId" id="user_edit"/>
				</form>
				
				<form id="query_form"  action="./queryUser.do" method="post">
					<input type="hidden" name="queryMessage" id="queryMessage" />
				</form>

				</div>
				<!-- //tables -->
			</div>
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
</html>