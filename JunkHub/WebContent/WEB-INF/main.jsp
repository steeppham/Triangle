<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>
<jsp:useBean id="websession" class="edu.unsw.triangle.model.WebSession" scope="session"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JunkHub</title>
</head>
<body>
	<h1>JunkHub</h1>
	<div style="color: #FF0000;">${errors.getErrorMessage("search.error")}</div><br>
	<c:if test="${websession.profile.admin}">
		<a href="admin">Admin</a>
	</c:if>
	<a href="profile">Profile</a>
	<a href="sell">Sell Item</a>
	<a href="logout">Logout</a>
	<form method="GET" action="search">
		<input type="submit" name="search"> 
		<input type="text" name="query" value="${query.findByTitle}"><br>
	</form>
	<c:choose>
	<c:when test="${result.size() == 0}">
		<h3>No search results</h3>
	</c:when>
	<c:when test="${empty result}">
	<!-- display nothing -->
	</c:when>
	<c:otherwise> 
		<!-- search results here -->
		<h3>Found ${result.size()} items matching search</h3>
		<table>
	      <c:forEach var="item" items="${result}">
	        <tr>
	          <td><a href="item?id=${item.id}">${item.title}</a></td>
	          <td>${item.title}</td>
	          <td>${item.category}</td>
	          <td>${item.start}</td>
	        </tr>
	      </c:forEach>
	    </table>
	</c:otherwise>
	</c:choose>
</body>
</html>