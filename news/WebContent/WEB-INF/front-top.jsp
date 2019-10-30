<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.xzm.model.*"%>
<link href="css/front-top.css" rel="stylesheet" type="text/css" />
<div class="body-top">
	<div class="logo"><div class="logo_center">
			<%
				String userName = (String) session.getAttribute("userName");
				if(userName == null){
			%>
				<form name="form" action="" method="post">
					<input name="userName" type="text" placeholder="用户名" class="input_text"/>
					<input name="userPass" type="password" placeholder="密码" class="input_text"/>
					<input type="button" class="input_button" value="登陆"  onclick="form.action='back/manage?action=login';form.submit();"/>
					<input type="button" class="input_button" value="注册" onclick="form.action='back/manage?action=register';form.submit();"/>
					<input type="reset"  class="input_button"value="重 置" />
				</form>
			<%} 
			else{
			%>
			<div>
				<p>用户名:<a href="back/manage?action=gologin"><%=userName %></a></p>
				<br/>
				<p><a href="back/manage?action=logout">&nbsp;下&nbsp;&nbsp;线&nbsp;</a></p>			
			</div>
			<% } %>
	</div></div>
	<div class="nav">
		<table>
		<tr>
			<td><a href="">网义首页</a>
			</td>
			<%
				Category[] categoryList = (Category[])request.getAttribute("categoryList");
				for(int i =0;i<categoryList.length;i++){
			%>
			<td><a href="category?action=look&id=<%=categoryList[i].getId()%>"><%=categoryList[i].getCategoryName() %></a>
			</td>
			<%
				}
			%>
		<tr>
		</table>
	</div>
</div>