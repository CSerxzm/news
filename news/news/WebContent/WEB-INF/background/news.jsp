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

<title>新闻更新</title>

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
	function setCategoryName(){
		var obj = document.getElementById("newsCategoryId"); //定位id
		var index = obj.selectedIndex; // 选中索引
		var text = obj.options[index].text; // 选中文本
		document.getElementById("newsCategoryName").value=text;
		return true;
	}
	function check(){
		if(setCategoryName()==true){
			return true;
		}
		return false;
	}
</script>
</head>

<body>
	<div class="body">
		<jsp:include page="back-top.jsp"></jsp:include>
		<div class="center">
			<h1>新闻更新</h1>
			<form action="back/manage/news" method="post"
				onsubmit="return check();">
				<input type="hidden" value="search" name="action"> 类别： <select
					name="newsCategoryId" id="newsCategoryId"
					style="min-height:24px;min-width: 100px;line-height: 24px;font-size: 16px;">
					<option
						style="min-height:24px;min-width: 100px;line-height: 24px;font-size: 16px;"
						value="0">-请选择-</option>
					<%
						Category[] categoryList = (Category[]) request
								.getAttribute("categoryList");
						for (int i = 0; i < categoryList.length; i++) {
					%>
					<option
						style="min-height:24px;min-width: 100px;line-height: 24px;font-size: 16px;"
						value="<%=categoryList[i].getId()%>"><%=categoryList[i].getCategoryName()%></option>
					<%
						}
					%>
				</select> <input type="hidden" id="newsCategoryName" name="newsCategoryName">
				<input type="hidden" value="1" name="page"> 标题：<input
					style="min-height:24px;width: 300px;line-height: 24px;font-size: 16px;"
					type="text" name="newsTitle"> <input type="submit"
					value="筛选">
			</form>
			<div style="min-height: 320px">
			<table  class="tablecontent">
				<tr>
					<td width="60px">编号</td>
					<td width="600px">标题</td>
					<td>发布时间</td>
					<td>操作</td>
				</tr>
				<%
					Map<String,Object> map = (Map<String,Object>)request.getAttribute("map");
					NewsList[] listNewsList  = (NewsList[])map.get("listNewsList");
					Page pageBean = (Page)map.get("pageBean");
					Object cate = map.get("newsCategoryId");
					int categoryId;
					if(null==cate){
						categoryId = 0;
					}else{
						categoryId = (Integer)cate;
					}
					for (int i = 0; i < listNewsList.length; i++) {
				%>
				<tr>
					<td><%=(pageBean.getCurrentPage()-1)*pageBean.getPageSize()+i+1%></td>
					<td style="text-align: left;"><a href="back/manage/news?action=look&id=<%=listNewsList[i].getNewsId()%>"><%=listNewsList[i].getNewsTitle()%></a></td>
					<td><%=listNewsList[i].getNewsPublishTime()%></td>
					<td><a
						href="back/manage/news?action=goupdate&id=<%=listNewsList[i].getNewsId()%>">更新</a>&nbsp;&nbsp;<a
						href="back/manage/news?action=delete&id=<%=listNewsList[i].getNewsId()%>"
						onclick="return confirmDelete();">删除</a></td>
				</tr>
				<%
					}
				%>
			</table>
			</div>
			<br>
			<table>
				<tr>
					<td>现在是第<%=pageBean.getCurrentPage()%>页</td>
					<td>共<%=pageBean.getTotalPages()%>页</td>
					<td>共<%=pageBean.getAllRecords()%>条</td>
					<td>
						<%
							if(!pageBean.isFirstPage()){
						%> <a
						href="back/manage/news?action=listnews&page=1&cate=<%=categoryId%>">首页</a>
						<%
							}
						%>
					</td>
					<td>
						<%
							if(pageBean.isHasPreviousPage()){
						%> <a
						href="back/manage/news?action=listnews&page=<%=pageBean.getCurrentPage()-1%>&cate=<%=categoryId%>">上一页</a>
						<%
							}
						%>
					</td>
					<td>
						<%
							if(pageBean.isHasNextPage()){
						%> <a
						href="back/manage/news?action=listnews&page=<%=pageBean.getCurrentPage()+1%>&cate=<%=categoryId%>">下一页</a>
						<%
							}
						%>
					</td>
					<td>
						<%
							if(!pageBean.isFinalPage()){
						%> <a
						href="back/manage/news?action=listnews&page=<%=pageBean.getTotalPages()%>&cate=<%=categoryId%>">尾页</a>
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