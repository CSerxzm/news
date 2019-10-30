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

<title>新闻类别管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="<%=basePath%>css/back.css" />
<script type="text/javascript">
function confirmDelete(){
	if(confirm("确定进行删除操作？")==true){
		return true;
	}else{
		return false;
	}
}
</script>
</head>

<body>
	<div class="body">
		<jsp:include page="back-top.jsp"></jsp:include>
		<div class="center">
			<h1>类别更新</h1>
			<br>
			<table style="border: 1px silver solid;" cellpadding="1px"
				cellspacing="1px"  class="tablecontent">
				<tr>
					<td width="60px">编号</td>
					<td width="600px">名称</td>
					<td>优先级</td>
					<td>操作</td>
				</tr>
				<%
					Category[] categoryList = (Category[]) request
							.getAttribute("categoryList");
					for (int i = 0; i < categoryList.length; i++) {
				%>
				<tr>
					<td><%=i + 1%></td>
					<td><%=categoryList[i].getCategoryName()%></td>
					<td><%=categoryList[i].getCategoryPriority()%></td>
					<td><a
						href="back/manage/category?action=goupdate&id=<%=categoryList[i].getId()%>">更新</a>&nbsp;&nbsp;<a
						href="back/manage/category?action=delete&id=<%=categoryList[i].getId()%>"
						onclick="return confirmDelete();">删除</a></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<jsp:include page="../front-bottom.jsp"></jsp:include>
	</div>
</body>
</html>
