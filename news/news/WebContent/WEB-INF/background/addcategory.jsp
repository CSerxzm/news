<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.xzm.model.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>类别添加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="<%=basePath%>css/back.css" />
<style type="text/css">
#pic-site-input {
	display: none;
}
</style>
</head>

<body>
	<div class="body">
		<jsp:include page="back-top.jsp"></jsp:include>
		<div class="center">
			<h1>类别添加</h1>
			<form action="back/manage/category?action=add" method="post">
				名&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="categoryName"> <br>
				<br> 优先级：<input type="text" name="categoryPriority"><br>
				<br> <input type="submit" value="确认发布">
			</form>
		</div>
		<jsp:include page="../front-bottom.jsp"></jsp:include>
	</div>
</body>
</html>
