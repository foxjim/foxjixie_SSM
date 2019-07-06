<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>计协 新闻动态</title>
		<link href="CSS/main.css" rel="stylesheet" type="text/css">
		<link href="CSS/container.css" rel="stylesheet" type="text/css">
		<link href="CSS/reset.css" rel="stylesheet" type="text/css">
		<link href="CSS/screen.css" rel="stylesheet" type="text/css">
		<script src="js/jquery.min.js">
</script>
		<script src="js/tab.js">
</script>
	</head>

	<body>
		<%@ include file="common_header.jsp"%>

		<!--banner-->
		<div class="second_banner">
			
			<h2 style="margin-top:20px;font-size:30px;line-height:50px;">${newsHead.nhTitle}</h2>
			<p style="color: #858585; text-align:center; font-size:15px;line-height:20px;">编者：<span>${newsHead.nhPerson}</span>&nbsp;&nbsp;发布时间：${newsHead.nhTime}</p>
			<hr>
		</div>
		<!--//banner-->
		<!--新闻-->
		<div class="container">
			${news.ncContent }
		</div>
				<!--底部-->
		<div style="height:350px;">
		 <p></p>
		</div>
		<%@ include file="common_footer.jsp"%>
		
	</body>

	<!--//底部-->
	<script>
tabs("#tab", "active", "#tab_con");
</script>


</html>
		
</body>
</html>