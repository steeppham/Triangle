<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	Login
	<c:set var="message" value="${message}"/> 
	<c:if test="${not empty message}">
		<!--Display message-->
		${message}			
	</c:if>
	<form method="POST" action="login">
		Please enter your username <input type="text" name="username" /><br>
		Please enter your password <input type="password" name="password" /><br>
		<input type="submit" value="submit">
	</form>
	<a href="register">Register</a>
</body>
</html>