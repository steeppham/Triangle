<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="login" class="edu.unsw.triangle.model.Login" scope="session">
	<jsp:setProperty name="login" property="*" />
</jsp:useBean>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	Login
	 <!-- listing of errors here -->	
	<div style="color: #FF0000;">${errors.getErrorMessage("username")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("password")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("authentication")}</div>
	<form method="POST" action="login">
		<p>Please enter your username <input type="text" name="username" value="${login.username}"/></p>
		<p>Please enter your password <input type="password" name="password" /><p>
		<input type="submit" value="login">
	</form>
	<a href="register">Register</a>
</body>
</html>