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

<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->

<script type="text/javascript" src="./js/news.js"></script>
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
                <li class="breadcrumb-item"><a href="#">新闻管理</a><i class="fa fa-angle-right"></i>添加新闻</li>
            </ol>
<!--grid-->
 	<div class="validation-system">
 		
 		<div class="validation-form">
 
  	   
        <form id="insertNews_action" action="InsertNews.jsp" method="post" >
        	
        	<%
        		AdminUser adminUser=(AdminUser)session.getAttribute("admin");
        		if(adminUser!=null){
        			String nhClass=adminUser.getAdminGrades();
        	%>
        	
        	<input type="hidden" id="nhClass" name="nhClass" value="<%=nhClass%>" >
        	<input type="hidden" id="nhId" name="nhId">
        	<%
        		}else{
        	%>
        		<input type="hidden" name="nhClass" id="nhClass" >
        		<script type="text/javascript">
        			var date=new Date;
        			document.getElementById('nhClass').value=date.getFullYear()%1000;
        		</script>
        	<%}%>
        	
        	<div class="col-md-12 form-group1 group-mail">
              <label class="control-label">标题 <span id="nhTitle_show" style="color:red; font-size:15px;font-weight:200;"></span></label>
              <input type="text" placeholder="标题" required="required" name="nhTitle" id="nhTitle" oninput="ensureNhTitle()" >
             
            </div>
             <div class="clearfix"> </div>
             
          
            <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">撰写时间</label>
              <input type="date" required="required" name="nhTime"  id="nhTime" >
            </div>
             <div class="clearfix"> </div>
            
              
              <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">撰稿人（小编）<span id="nhPerson_show" style="color:red; font-size:15px;font-weight:200;"></span></label>
              <input type="text" placeholder="撰稿人" required="required" name="nhPerson" id="nhPerson" oninput="ensureNhPerson()" >
            </div>
             <div class="clearfix"> </div>
             
               <div class="col-md-12 form-group1 group-mail">
              		<label class="control-label"><input type="checkbox" id="userOther" oninput="ensureUserOther()">使用外部链接<span id="otherLink_show" style="color:red;font-family:楷体; font-size:15px;font-weight:200;"></span></label>
             		<input type="text" placeholder="若需使用外部链接请勾选上方选框" name="otherLink" id="otherLink" oninput="ensureOtherLink()" readonly="readonly">
           	   </div>
             <div class="clearfix"> </div>
             
             <input type="hidden" id="userLink" name="userLink" value="0">

	
            <div class="col-md-12 form-group">
              <button type="button" onclick="ensureNewsHead()" class="btn btn-primary">提交</button>
              <button type="reset" class="btn btn-default">重置</button>
            </div>
         	 <div class="clearfix"> </div>
          
        </form>
    	
 	
 </div>

</div>
 	<!--//grid-->


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

<script type="text/javascript">
	clearInputValue();
</script>
</body>
</html>