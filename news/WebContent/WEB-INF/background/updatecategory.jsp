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

<title>编辑新闻类别</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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
				<% Category category = (Category)request.getAttribute("categoryList"); %>
				<h1>编辑新闻类别</h1>
				<form action="back/manage/category?action=update" method="post">
				<input type="hidden" name="categoryId" value="<%=category.getId()%>">
					名&nbsp;&nbsp;称：<input type="text" name="categoryName" value="<%=category.getCategoryName()%>"> <br> <br>
					优先级：<input type="text" name="categoryPriority"  value="<%=category.getCategoryPriority()%>"><br> <br>
					<input type="submit"  value="确认保存">
				</form>
			</div>
	<jsp:include page="../front-bottom.jsp"></jsp:include>
	</div>
</body>
</html>
