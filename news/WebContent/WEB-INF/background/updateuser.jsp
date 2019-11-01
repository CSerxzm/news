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

<title>更新用户</title>

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
				<% String userName = (String)request.getAttribute("userName"); %>
				<h1>更新用户</h1>
				<form action="back/manage/user?action=update" method="post">
				用户名:<input readonly  unselectable="on" name="userName" value="<%=userName%>">
				 <br> <br>
					密&nbsp;&nbsp;码:<input type="text" name="userPass"/> <br> <br>
					是否为管理员用户:<select
					style="min-height:30px;min-width: 100px;line-height: 30px;font-size: 16px;"
					name="isRoot">
					<option
						style="min-height:30px;min-width: 100px;line-height: 30px;font-size: 16px;"
						value="false">否</option>
					<option
						style="min-height:30px;min-width: 100px;line-height: 30px;font-size: 16px;"
						value="true">是</option>
				</select><br> <br>
					<input type="submit"  value="确认保存">
				</form>
			</div>
	<jsp:include page="../front-bottom.jsp"></jsp:include>
	</div>
</body>
</html>
