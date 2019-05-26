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
<!-- tables -->
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
<link href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'/>
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head> 
<body>
   <div class="page-container">
	 <!--/content-inner-->
	 
	 <!--Start of left-content-->
<div class="left-content">
	   <div class="mother-grid-inner">
            <!--header start here-->
						<%@ include file="./head_common.jsp" %>
<!--heder end here-->
<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.jsp">社团文化</a><i class="fa fa-angle-right"></i>社团活动列表</li>
            </ol>
<div class="agile-grids">	
				<!-- tables -->
				
				
				<div class="agile-tables">
					<div class="w3l-table-info">
					<c:forEach var="snt" items="${scllist}">
					  <h2>${snt.cultureClass}活动<span style="font-size:15px;"><a href="InsertSocietyCulture.jsp?term=${snt.cultureClass}">(添加)</a></span></h2>
					    <table id="table">
						<thead>
						  <tr>
							<th>序号</th>
							<th>类型</th>
							<th>时间</th>
							<th>操作</th>
						  </tr>
						</thead>
						<tbody>
						<c:forEach var="snl" items="${snt.cultureClassList}">
						 <tr>
						 	<td>${snl.scid}</td>
						 	<td>${snl.cultureClass}</td>
						 	<td>${snl.cultureTime}</td>
						 	<td><a href="deleteSocietyCulture?scid=${snl.scid}">删除</a>&nbsp;|&nbsp;<a href="editSocietyCulture?temp=0&scid=${snl.scid}">编辑</a></td>
						 </tr>
						</c:forEach>
						</tbody>
					  </table>
					  </c:forEach>
					</div>
				 <br />
				 <br />
				 <br />
		


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