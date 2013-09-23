<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
Register
	<c:set var="message" value="${message}"/> 
	<c:if test="${not empty message}">
		<!--Display message-->
		X ${message}			
	</c:if>
	<form method="POST" action="register">
		Username <input type="text" name="username" /><br>
		Password <input type="password" name="password" /><br>
		Email address <input type="text" name="email" /><br>
		First name <input type="text" name="firstname" /><br>
		Last name <input type="text" name="lastname" /><br>
		Date of birth <input type="text" name="dob" /><br>
		Address <input type="text" name="address" /><br>
		Credit card number <input type="text" name="credit" /><br>
		<input type="submit" value="register">
	</form>
	<a href="login">Login</a>
</body>
</html>