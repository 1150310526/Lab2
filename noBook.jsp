<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>图书管理</title>
<style>
#intro {
	line-height: 200px;
	text-align: center;
}

#content {
	background-color: #fff;
}
</style>
</head>
<body>

	<h2 id="headline">
		<a href="index.jsp">图书管理</a>
	</h2>

			<ul>
				<li><a href="<s:url action='list' />">浏览全部图书</a></li>
				<li><a href="<s:url action='listAuthors' />">浏览全部作者</a></li>
				<li><a href="<s:url action='searchInput' />">查询指定作者</a></li>

			</ul>

	
				<h1>暂无书目！</h1>
			
	
</body>
</html>