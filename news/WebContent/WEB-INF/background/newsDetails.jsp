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
<%
	NewsDetails newsDetails = (NewsDetails) request
			.getAttribute("newsDetails");
%>
<title><%=newsDetails.getNewsTitle()%></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/back.css" />
</head>

<body class="newsDetails-body">
	<div class="body">
		<jsp:include page="back-top.jsp"></jsp:include>
		<div class="center">
			<div class="newsDetails-body-middle">
				<div class="newsDetails-body-middle-content news-detail">
					<h1><%=newsDetails.getNewsTitle()%></h1>
					<p>
						发表时间：<%=newsDetails.getNewsPublishTime()%>&nbsp;&nbsp;阅读次数：<%=newsDetails.getNewsHitCount()%>&nbsp;&nbsp;评论条数：<%=newsDetails.getNewsCommentCount()%>
					</p>
					<div>
						<%=newsDetails.getNewsContent()%>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../front-bottom.jsp"></jsp:include>
	</div>
</body>
</html>
