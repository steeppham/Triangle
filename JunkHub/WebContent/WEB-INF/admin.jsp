<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
<h1>Admin</h1>
<div style="color: #FF0000;">${errors.getErrorMessage("admin.profiles.error")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("admin.items.error")}</div>

<!-- show list of users -->

<h3>Profiles</h3>
<form action="admin.profile" method="POST">
<table>
	<tr>
		<td></td>
		<td>Username</td>
		<td>Status</td>
	</tr>
	<c:forEach  var="profile" items="${profiles}">
	<c:if test="${not profile.admin}">
	<tr>
		<td>
			<c:choose>
			<c:when test="${profile.status eq 'ACTIVE'}">
			<input type="checkbox" name="suspend.profiles" value="${profile.username}"/>
			</c:when>
			<c:otherwise>X</c:otherwise>
			</c:choose>	
		</td>
		<td>${profile.username}</td><td>${profile.status}</td>
	</tr>
	</c:if>
	</c:forEach>
</table>
<input type="submit" name="suspend.profile" value="suspend users"/>
</form>

<!-- show list of auctions -->
<h3>Items</h3>
<form action="admin.item" method="POST">
<table>
	<tr>
		<td></td>
		<td>Title</td>
		<td>Status</td>
		<td>Owner</td>	
	</tr>
	<c:forEach  var="item" items="${items}">
	<tr>
		<td>
		<c:choose>
			<c:when test="${item.status eq 'NOT_ACTIVE'}">X</c:when>
			<c:otherwise><input type="checkbox" name="suspend.items" value="${item.id}"/></c:otherwise>
		</c:choose>
		</td>
		<td>${item.title}</td><td>${item.status}</td><td>${item.owner}</td>
	</tr>
	</c:forEach>
</table>
<input type="submit" name="suspend.item" value="suspend items"/>
</form>


<p><a href="main">Main</a></p>
</body>
</html>