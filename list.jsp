<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>

<script type="text/javascript">
	window.onload = function() {
		var cb = document.getElementById("all");
		var items = document.getElementsByClassName("items");
		cb.onclick = function() {
			for (var i = 0; i < items.length; i++) {
				items[i].checked = this.checked;
			}
		}
	}
</script>
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
						<th class="xz">选择</th>
						<th class="isbn">ISBN号</th>
						<th class="sm">书名</th>
						<th class="zzbh">作者编号</th>
						<th class="cbs">出版社</th>
						<th class="cbrq">出版日期</th>
						<th class="jg">价格</th>
						<th class="cz">操作</th>
					</tr>
				</thead>
			</table>

				<s:form action="deleteSelectedBook">
					<table width="85%" border="1" align="center">
		<tr bgcolor="#949494">
						<tbody>
							<s:iterator value="books">
								<tr>
									<td class="xz"><input type="checkbox" name="isbns"
										value='<s:property value="isbn" />' class="items" /></td>
									<td class="isbn"><s:property value="isbn" /></td>
									
									<td class="sm">
											<s:property value="title" />
									</td>
		
									<td class="zzbh">
									<a class="titlelink" href="<s:url action='searchAuthor'> <s:param name='authorID' value='authorID' /> </s:url>">
									<s:property value="authorID" />
									</a></td>
									<td class="cbs"><s:property value="publisher" /></td>
									<td class="cbrq"><s:property value="publishDate" /></td>
									<td class="jg">￥<s:property value="price" /></td>
									<td class="cz" colspan="2">
										
										<a class="danger"
										href="<s:url action='deleteSingleBook'> <s:param name='isbn' value='isbn' /> </s:url>"
										onclick="javascript:if(confirm('确定要删除本书吗？')){alert('删除成功!');return true;}return false;">
											删除</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>

			
				<input type="checkbox" name="isbns" value="" id="all" /> <label
					for="all">全选/全不选</label>

			
					<input type="submit" value="删除" id="removeAll"
						onclick="javascript:if(confirm('确定要删除所选条目吗？')){alert('删除成功!');return true;}return false;" />


		
			</s:form>

		
</body>
</html>