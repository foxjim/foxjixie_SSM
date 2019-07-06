<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="org.hnist.model.User" %>

<link type="text/css" rel="stylesheet" href="../js/formcommonCss.css">
<script type="text/javascript" src="../js/register.js"></script>
	<!-- from 弹框 -->
					
					<div class="ui-mask" id="mask" onselectstart="return false"></div>

					<div class="ui-dialog" id="dialogMove" onselectstart='return false;'>

						<div class="ui-dialog-title" id="dialogDrag" onselectstart="return false;">
							计协会员登录 <a style="float:right;z-index:100;" class="ui-dialog-closebutton" href="javascript:hideDialog();">X</a>
						</div>

						<div class="ui-dialog-content">

							<div class="ui-dialog-l40 ui-dialog-pt15">
								<input class="ui-dialog-input ui-dialog-input-username" type="text" placeholder="学号/QQ号" id="userNo" name="userNo" />

							</div>

							<div class="ui-dialog-l40 ui-dialog-pt15">
								<input class="ui-dialog-input ui-dialog-input-password" id="userPassword" name="userPassword" type="password" placeholder="密码" value="" />

							</div>

							

							<div>
								<a class="ui-dialog-submit" href="javascript:void(0)" onclick="login()">登录</a>
							</div>

							<div class="ui-dialog-l40">
								<a style="float:left;" href="../forgetPassword.jsp">忘记密码</a>
								<a style="float:rigth;" href="../register.jsp">立即注册</a>
							</div>

						</div>

					</div>
					
					<div class="ui-mask" id="mask" ></div>
					<!-- from 弹框 -->

<!--头部-->
		<div class="header_bg">
			<div class="wrap">
				<div class="header">
					<div class="logo">
						<a href="queryPictures"><img src="./img/logojx.png" alt=""> </a>
					</div>
					<div style="float:right">
								<%
									User user=(User)session.getAttribute("user");
								
									if(user==null){
								%>
									<a>您好，先</a><a href="javascript:void(0)" onclick="showDialog()">注册登录</a>
								<%
									}else{
								%>
								<a>您好！<%=user.getUserName()%></a>
								
								<%
									}
								%>
					</div>
					<div class="pull-icon">
						<a id="pull"></a>
					</div>
					<div class="cssmenu">
						<input type="checkbox" id="nav-toggle" class="nav-toggle"/>
            <label for="nav-toggle">
                <span class="menu-icon">
                    <svg viewBox="0 0 18 15" width="18px" height="15px">
                        <path fill="white" d="M18,1.484c0,0.82-0.665,1.484-1.484,1.484H1.484C0.665,2.969,0,2.304,0,1.484l0,0C0,0.665,0.665,0,1.484,0 h15.031C17.335,0,18,0.665,18,1.484L18,1.484z"/>
                        <path fill="white" d="M18,7.516C18,8.335,17.335,9,16.516,9H1.484C0.665,9,0,8.335,0,7.516l0,0c0-0.82,0.665-1.484,1.484-1.484 h15.031C17.335,6.031,18,6.696,18,7.516L18,7.516z"/>
                        <path fill="white" d="M18,13.516C18,14.335,17.335,15,16.516,15H1.484C0.665,15,0,14.335,0,13.516l0,0 c0-0.82,0.665-1.484,1.484-1.484h15.031C17.335,12.031,18,12.696,18,13.516L18,13.516z"/>
                   </svg>
              </span>
            </label>
            			
						<ul style="z-index:10;" class="nav-list">
							<li>
								<a href="./Index.do">首页</a>
							</li>
							<li>
								<a href="./SocietyNews.do">新闻动态</a>
							</li>
							<li>
								<a href="./SocietyCulture.do">社团文化</a>
							</li>
							<li>
								<a href="./Download.do">社团资源</a>
							</li>
							<li class="last">
								<a href="./Contact.do">关于我们</a>
							</li>
						</ul>
					</div>
					<!--清除浮动-->
					<div class="clear"></div>
					<script language="javascript">

					</script>
				</div>
			</div>
		</div>
<!--头部-->
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

