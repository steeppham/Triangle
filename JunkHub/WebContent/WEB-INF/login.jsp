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
<h1>Login</h1>
 <!-- messages -->	
<div style="color: #FF0000;">${errors.getErrorMessage("username")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("password")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("authentication")}</div>
<br>
<!-- form -->
<form method="POST" action="login">
	<table>
	<tr><td>username</td><td><input type="text" name="username" value="${login.username}"></td></tr>
	<tr><td>password</td><td><input type="password" name="password"></td></tr>
	</table>
	<input type="submit" value="login">
</form>
<!-- navigation -->
<a href="register">Register</a>
</body>
</html>