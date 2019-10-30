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

<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/back.css">
<script type="text/javascript">
function confirmDelete(){
	if(confirm("确定进行删除操作，操作不可逆！请谨慎操作！")==true){
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
			<h1>用户维护</h1>
			<br>
			<div style="min-height: 350px">
				<table class="tablecontent" style="border: 1px silver solid;" cellpadding="1px"
					cellspacing="1px">
					<tr>
						<td width="40px">编号</td>
						<td width="100px">用户名</td>
						<td>密码</td>
						<td>管理员</td>
						<td>操作</td>
					</tr>
					<%
						Map<String, Object> map = (Map<String, Object>)request.getAttribute("map");
						Users[] userList = (Users[]) map.get("userList");
						Page pageBean =(Page)map.get("pageBean");
						for (int i = 0; i < userList.length; i++) {
							Users user =userList[i];
					%>
					<tr>
						<td><%=i+1%></td>
						<td><%=user.getUserName()%></td>
						<td><%=user.getUserPass()%></td>
						<td><%=user.getIsRoot()%></td>
						<td><a
							href="back/manage/user?action=delete&userName=<%=user.getUserName()%>"
							onclick="return confirmDelete();">删除</a></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<table>
				<tr>
					<td>现在是第<%=pageBean.getCurrentPage()%>页</td>
					<td>共<%=pageBean.getTotalPages()%>页</td>
					<td>共<%=pageBean.getAllRecords()%>条</td>
					<td>
						<%
							if(!pageBean.isFirstPage()){
						%> <a href="back/manage/user?action=list&page=1">首页</a> <%
 	}
 %>
					</td>
					<td>
						<%
							if(pageBean.isHasPreviousPage()){
						%> <a
						href="back/manage/user?action=list&page=<%=pageBean.getCurrentPage()-1%>">上一页</a>
						<%
							}
						%>
					</td>
					<td>
						<%
							if(pageBean.isHasNextPage()){
						%> <a
						href="back/manage/user?action=list&page=<%=pageBean.getCurrentPage()+1%>">下一页</a>
						<%
							}
						%>
					</td>
					<td>
						<%
							if(!pageBean.isFinalPage()){
						%> <a
						href="back/manage/user?action=list&page=<%=pageBean.getTotalPages()%>">尾页</a>
						<%
							}
						%>
					</td>
				</tr>
			</table>
		</div>
		<jsp:include page="../front-bottom.jsp"></jsp:include>
	</div>
</body>
</html>
