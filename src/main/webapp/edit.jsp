<%@page import="java.util.List"%>
<%@page import="com.cy.model.User"%>
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
	你要更新的用户：
	<form action="<%=request.getContextPath()%>/user/update" method="post">
	<table>
		<tr><td>姓名</td><td>电话</td></tr>
		<c:forEach items="${userlist}" var="user">
		<tr>
			<td><input name="name" id="name" type="text" value='<c:out value="${user.name}"></c:out>'></td>
			<td><input name="tel" id="tel" type="text" value='<c:out value="${user.tel}"></c:out>'></td>
			<td><input name="id" id="id" type="hidden" value=<c:out value="${user.id}"></c:out>></td>
		</tr>
		</c:forEach>
	</table>
	<input name="submit" type="submit" value="确定">
	</form>
</body>
</html>