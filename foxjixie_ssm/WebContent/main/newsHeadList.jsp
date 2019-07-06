<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.hnist.model.AdminUser" %>

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
<script src="js/showNews.js"></script>
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
                <li class="breadcrumb-item"><a href="#">新闻管理</a><i class="fa fa-angle-right"></i>计协新闻列表</li>
            </ol>
<div class="agile-grids">	
				<!-- tables -->
				
				
				<div class="agile-tables">
					<div class="w3l-table-info">
					
					  <h2>本年度新闻列表<span style="font-size:15px;"><a style="cursor:pointer;" href="InsertNewsHead.jsp">(添加)</a></span></h2>
					    <table id="table">
						<thead>
						  <tr>
							<th>序号</th>
							<th>新闻标题</th>
							<th>新闻时间</th>
							<th>发布人</th>
							<th>新闻链接</th>
							<th>链接设置</th>
							<th>编辑操作</th>
						  </tr>
						</thead>
						<tbody id="table_body">
						<c:forEach var="news" items="${newsList.newsHeads}" varStatus="status">
						
						
						 <tr id="${news.nhId}z">
						 	<input type="hidden" id="${news.nhId}zz" value="${requestScope.offset+status.index+1}"/>
						 	<td>${requestScope.offset+status.index+1}</td>
						 	<td>${news.nhTitle}</td>
						 	<td>${news.nhTime}</td>
						 	<td>${news.nhPerson}</td>
						 	
						 	<c:if test="${news.userLink==0}">
						 		<td>内部链接</td>
						 	</c:if>
						 	<c:if test="${news.userLink==1}">
						 		<td>外部链接</td>
						 	</c:if>
						 	
						 	
						 	<input type="hidden" id="userLink_id${news.nhId}" value="${news.userLink}"/>
						 	<td><a href="javascript:void(0)" onclick="setUserLink(0,'${news.nhId}')">内</a>&nbsp;|&nbsp;<a href="javascript:void(0)"onclick="setUserLink(1,'${news.nhId}')">外</a></td>
						 	<td><a href="javascript:void(0)" onclick="deleteNews('${news.nhId}')">删除</a>&nbsp;|&nbsp;<a href="editorNews.do?nhId=${news.nhId}">编辑</a>&nbsp;|&nbsp;<a href="editNewsContent.do?nhId=${news.nhId}">撰写</a></td>
						 </tr>
						</c:forEach>
						</tbody>
						
					  </table>
						<div id="table_message" style="color:red;" ></div>
					</div>
					
					<div style="margin-top:10px; margin-right:2%;width:100%" class="js">
					<p class="js_left" style="font-size:15px; float:left;">第 <span style="font-color:red;"id="currentpage">${newsList.currentPage}</span> 页 |
					 共 <span style="font-color:red;">${newsList.totalPage}</span> 页 | 
					 共  <span style="font-color:red;">${newsList.totalNumber}</span> 条数据&nbsp;&nbsp;&nbsp;&nbsp;</p> 
					
					 
					<a class="js_right"style="float:left;" href="showAllNews.do?nhClass=${grades }&nhPage=1">[首页]&nbsp;&nbsp;</a>
					
					
					<a style="float:left;" href="showAllNews.do?nhClass=${grades }&nhPage=${newsList.upPage}">[上一页]&nbsp;&nbsp;</a>
				
					<a style="float:left;" href="showAllNews.do?nhClass=${grades }&nhPage=${newsList.nextPage}">&nbsp;&nbsp;[下一页]&nbsp;&nbsp;</a>
					
				
					<a style="clear:both;" href="showAllNews.do?nhClass=${grades }&nhPage=${newsList.totalPage}">[尾页]</a>
					 
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

<script type="text/javascript">
	
	
</script>




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
