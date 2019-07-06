<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>计协 资源下载</title>
<link href="CSS/main.css" rel="stylesheet" type="text/css">
<link href="CSS/container.css" rel="stylesheet" type="text/css">
<link href="CSS/reset.css" rel="stylesheet" type="text/css">
<link href="CSS/screen.css" rel="stylesheet" type="text/css">
<link href="CSS/content.css" rel="stylesheet" type="text/css">
<script src="js/jquery.min.js">
</script>
<script src="js/tab.js">
</script>
</head>

<body>
	<%@ include file="common_header.jsp"%>

	<!--核心竞争力-->
	<div class="container">
		<div>
			<div class="location1">
				<span>当前位置：<a href="#">社团资源</a>
				</span>
				<div class="brief width_170">资源下载链接</div>
			</div>


			<%
									
								
									if(user==null){
					%>
			<p style="clear: both; height: 100px; width: 100%;"></p>
			<p style="font-size: 30px; width: 100%; margin: 0 auto;">
				<a>您好，先</a><a  href="javascript:void(0)" onclick="showDialog()">注册登录</a>
			</p>
			<p style="height: 200px; width: 100%;"></p>
			<%
									}else{
								%>


			<div class="content_main" style="min-height: 300px;">
				<c:if test="${empty sclists }">
					暂无资源，请联系管理员进行资源上传
				</c:if>
				<br>
				<c:forEach var="snt" items="${sclists}">
					<br>
					<p style="font-size: 20px;">${snt.resourceClass}:</p>
					<c:forEach var="snl" items="${snt.resources}">

						<a class="cm-link" target="_blank" href="${snl.resourceLink}">${snl.resourceName}
							<c:if test="${not empty snl.resourcePassword }">密码：${snl.resourcePassword}</c:if>
						</a>
						<br>
					</c:forEach>

				</c:forEach>

			</div>

			<%
									}
				%>



		</div>
	</div>
	<!--//核心竞争力-->
	<!--底部-->
	<%@ include file="common_footer.jsp"%>

</body>

<!--//底部-->
<script>
tabs("#tab", "active", "#tab_con");
</script>

</html>
