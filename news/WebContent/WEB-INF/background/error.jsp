<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>操作出错</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="<%=basePath%>css/back.css" />

</head>

<body>
	<div class="body">
		<jsp:include page="back-top.jsp"></jsp:include>
		<div class="center">操作出错</div>
		<jsp:include page="../front-bottom.jsp"></jsp:include>
	</div>
</body>
</html>
