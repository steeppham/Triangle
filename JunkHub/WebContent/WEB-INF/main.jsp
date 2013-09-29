<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>
<jsp:useBean id="websession" class="edu.unsw.triangle.model.WebSession" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Main Page
	<form method="GET" action="search">
		<input type="submit" name="search"> 
		<input type="text" name="query"><br>
	</form>
	<!-- Search results shown below -->
		
			<!--Display message-->
			SEARCH RESULT
			<c:choose>
			<c:when test="${result.size() == 0}">
				NO RESULTS
			</c:when>
			<c:otherwise> 
				<!-- search results here -->
				${result.size()}
			</c:otherwise>
			</c:choose>

	<a href="profile">Profile</a>
</body>
</html>