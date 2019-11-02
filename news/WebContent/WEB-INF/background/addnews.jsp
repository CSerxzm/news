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

<title>新闻添加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="<%=basePath%>/umeditor/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="<%=basePath%>/umeditor/jquery-1.10.2.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>/umeditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>/umeditor/umeditor.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/umeditor/lang/zh-cn/zh-cn.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/back.css" />
<style type="text/css">
#pic-site-input {
	display: none;
}
</style>
<script type="text/javascript">
	function showPicSiteInput() {
		if (document.getElementById("newsIsPicture").checked == true) {
			document.getElementById("pic-site-input").style.display = "block";
			document.getElementById("newsIsPicture").value = "true";
		} else {
			document.getElementById("pic-site-input").style.display = "none";
			document.getElementById("newsIsPicture").value = "false";
		}
		return true;
	}
	function setTopInput() {
		if (document.getElementById("newsIsTopLine").checked == true) {
			document.getElementById("newsIsTopLine").value = "true";
		} else {
			document.getElementById("newsIsTopLine").value = "false";
		}
		return true;
	}
	function setHotInput(){
		if (document.getElementById("newsIsHot").checked == true) {
			document.getElementById("newsIsHot").value = "true";
		} else {
			document.getElementById("newsIsHot").value = "false";
		}
		return true;
	}
	function checkInput(){
		$("#newsContent").val(editor.getContent());
		if(showPicSiteInput()==true && setTopInput()==true && setHotInput()==true ){
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
			<%
				Category[] categoryList = (Category[]) request
						.getAttribute("categoryList");
			%>
			<h1>新闻添加</h1>
			<form style="text-align:left;"action="<%=basePath%>back/manage/news?action=addnews"
				method="post" onsubmit="return checkInput();"
				enctype="multipart/form-data">
				标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input
					style="	min-height: 30px;min-width: 400px;" type="text"
					name="newsTitle"> <br>
				<br> 新闻类别：<select
					style="min-height:30px;min-width: 100px;line-height: 30px;font-size: 16px;"
					name="newsCategoryId" id="newsCategoryId">
					<%
						for (int i = 0; i < categoryList.length; i++) {
					%>
					<option
						style="min-height:30px;min-width: 100px;line-height: 30px;font-size: 16px;"
						value="<%=categoryList[i].getId()%>"><%=categoryList[i].getCategoryName()%></option>
					<%
						}
					%>
				</select> <br> <br> 新闻属性： <input type="checkbox"
					onclick="showPicSiteInput()" value="false" id="newsIsPicture"
					name="newsIsPicture"> <label for="newsIsPicture">图片新闻</label>
				<input type="checkbox" onclick="setTopInput()" value="false"
					id="newsIsTopLine" name="newsIsTopLine"> <label
					for="newsIsTopLine">今日头条</label> <input type="checkbox"
					value="false" onclick="setHotInput()" id="newsIsHot"
					name="newsIsHot"> <label for="newsIsHot">热点新闻</label><br>
				<br>
				<div id="pic-site-input">
					图片地址：<input type="file" id="picFile" name="picFile" />
				</div>
				<br> 新闻内容：<br>
				<br>
				<textarea style="display: none" id="newsContent" name="newsContent"></textarea>
				<script id="container" name="content" type="text/plain" ></script>
				<script type="text/javascript">
    	    var editor = UM.getEditor('container');
    	</script>
				<br>
				<br> <input type="submit" style="height: 30px;font-size: 16px;"
					value="确认发布">
			</form>
		</div>
		<jsp:include page="../front-bottom.jsp"></jsp:include>
	</div>
</body>
</html>
