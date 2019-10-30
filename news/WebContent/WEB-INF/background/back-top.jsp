<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.xzm.model.*"%>
<link href="css/front-top.css" rel="stylesheet" type="text/css" />
<div class="body-top">
	<div class="logo"></div>
	<div class="nav">
		<table>
		<tr>
			<td><a href="back/manage/news?action=goaddnews">新闻添加</a>
			</td>
			<td><a href="back/manage/news?action=listnews&page=1" >新闻更新</a>
			</td>
			<td><a href="back/manage/category?action=goadd" >类别添加</a>
			</td>
			<td><a href="back/manage/category?action=list" >类别更新</a>
			</td>
			<td><a href="back/manage/comment?action=list" >评论更新</a>
			</td>
			<td><a href="back/manage/user?action=list" >用户更新</a>
			</td>			
			<td><a href="./index.jsp">返回首页</a>
			</td>
		</tr>
		</table>
	</div>
</div>