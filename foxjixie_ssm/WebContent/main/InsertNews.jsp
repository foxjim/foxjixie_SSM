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
<!-- jQuery -->
<script src="js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->

<script type="text/javascript" src="./js/news.js"></script>

<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->

    <script type="text/javascript" charset="utf-8" src="./utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="./utf8-jsp/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="./utf8-jsp/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        #editor{
            width:100%;
            height:auto;
            min-height:300px;
        }
    </style>
    
    
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
             <!--header start here-->
				<%@ include file="./head_common.jsp" %>
<!--heder end here-->
			<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">主菜单</a><i class="fa fa-angle-right"></i>系统须知 </li>
            </ol>
<!-- faq -->
				
				
			<div class="validation-system">
				<div class="validation-form">
					 <form id="form" action="" method="post"  target="_blank">
					 
					 	
					 		<%
					 			String title=request.getParameter("nhTitle");
					 			String nhId=request.getParameter("nhId");
					 		%>
					 		<input type="hidden" name="nhId" value="<%=nhId%>">
					 	  <h2 style="text-align:center;"><%=title%> <br><span style="text-align:center;font-size:15px;">作者：<%=request.getParameter("nhPerson") %>&nbsp;&nbsp; 时间: <%=request.getParameter("nhTime") %></span></h2>
					 	 
             			 <input type="hidden" id="nhId" name="nhId" value="<%=nhId%>">

    
    				 <script id="editor" name="editor" type="text/plain" >
							您可以编辑新闻内容了！
					</script>
   					  <input type="submit" value="提交">
						<input type="button" onclick="updateNewsContent()" value="获取">
             			
					 </form>	
				</div>
			</div>
			
			<script type="text/javascript">

    			//实例化编辑器
    			//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    			var ue = UE.getEditor('editor');
    
    

			</script>
				<!-- //faq -->
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