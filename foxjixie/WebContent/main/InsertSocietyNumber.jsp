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
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<script type="text/javascript" src="./js/societyNumber.js"></script>
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
                <li class="breadcrumb-item"><a href="#">关于社团</a><i class="fa fa-angle-right"></i>添加社团成员</li>
            </ol>
<!--grid-->
 	<div class="validation-system">
 		
 		<div class="validation-form">
 
  	   
        <form action="insertSocietyNumber" method="post" onsubmit="return false">
             
              <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">部门名称</label>
              <input type="text" placeholder="名称" required="required" id="societyNumberDepartment" name="societyNumberDepartment" >
            </div>
             <div class="clearfix"> </div>
             
               <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">部长</label>
              <input type="text" placeholder="部长" required="required" id="societyNumberOldMember" name="societyNumberOldMember" >
            </div>
             <div class="clearfix"> </div>
             
               <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">副部长</label>
              <input type="text" placeholder="副部" name="societyNumberYoungerMember"  id="societyNumberYoungerMember">
            </div>
             <div class="clearfix"> </div>
             

	
            <div class="col-md-12 form-group">
              <button type="button" onclick="insertSocietyNumber()" class="btn btn-primary">提交</button>
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
</html>
