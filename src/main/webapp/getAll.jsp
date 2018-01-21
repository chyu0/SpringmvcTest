<%@page import="com.cy.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/index.jsp">添加用户</a>
	<table border="1">
	<tr><td>姓名</td><td>电话</td><td>操作</td></tr>
	<c:forEach items="${userlist}" var="user">
		<tr>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.tel}" /></td>
			<td><a href="<%=request.getContextPath()%>/user/delete?id=<c:out value="${user.id}"/>">删除</a> <a
				href="<%=request.getContextPath()%>/user/edit?id=<c:out value="${user.id}"/>">编辑</a></td>
		</tr>
	</c:forEach>
	</table>
	
	<form action="<%=request.getContextPath()%>/user?method=findUser" method="post">
		<input name="name" id="name" type="text">
		<input name="submit" type="submit" value="查询">
	</form>
	
	<!-- commit6 -->
</body>
</html>