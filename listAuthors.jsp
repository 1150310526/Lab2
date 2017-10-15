<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>图书管理</title>
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

			<table width="85%" border="1" align="center">
		<tr bgcolor="#949494">
				<thead>
					<tr>
						<th class="authorID">编号</th>
						<th class="name">姓名</th>
						<th class="age">年龄</th>
						<th class="country">国家</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="authors">
						<tr>
							<td><s:property value="authorID" /></td>


							<td class="zzm">
									<s:property value="name" />
							</td>

							<td><s:property value="age" /></td>
							<td><s:property value="country" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		
</body>
</html>