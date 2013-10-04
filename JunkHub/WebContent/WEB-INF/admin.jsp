<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
ADMIN PAGE ${profile.username}
<div style="color: #FF0000;">${errors.getErrorMessage("admin.profiles.error")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("admin.items.error")}</div>

<!-- show list of users -->

<h3>Profiles</h3>
<table>
	<c:forEach  var="profile" items="${profiles}">
	<tr>
		<td>${profile.username} ${profile.status}</td>
	</tr>
	</c:forEach>
</table>

<!-- show list of auctions -->
<h3>Items</h3>
<table>
	<c:forEach  var="item" items="${items}">
	<tr>
		<td>${item.title} ${item.status}</td>
	</tr>
	</c:forEach>
</table>


<a href="main">Main</a>
</body>
</html>