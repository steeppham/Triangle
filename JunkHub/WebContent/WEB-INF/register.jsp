<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>
<jsp:useBean id="profile" class="edu.unsw.triangle.model.Profile" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<h1>Register</h1>

	<!-- ui messages here -->
	<div style="color: #FF0000;">${errors.getErrorMessage("register.error")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("username")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("password")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("email")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("firstname")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("lastname")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("nickname")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("address")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("dob")}</div>
	<div style="color: #FF0000;">${errors.getErrorMessage("credit")}</div>
	<br>
	
	
	<form method="POST" action="register">
	<table>
		<tr><td>Username:</td><td><input type="text" name="username" value="${profile.username}" maxlength= "20"></td></tr>
		<tr><td>Password:</td><td><input type="password" name="password" value="${profile.password}" maxlength= "20"></td></tr>
		<tr><td>Nickname:</td><td><input type="text" name="nickname" value="${profile.nickname}" maxlength= "20"></td></tr>
		<tr><td>Email:</td><td><input type="text" name="email" value="${profile.email}" maxlength= "20"></td></tr>
		<tr><td>First Name:</td><td><input type="text" name="firstname" value="${profile.firstname}" maxlength= "20"/></td></tr>
		<tr><td>Last Name:</td><td><input type="text" name="lastname" value="${profile.lastname}" maxlength= "20"/> </td></tr>
		<tr><td>Date of Birth:</td><td><input type="text" name="dob" value="${profile.dob}" maxlength= "10"/> </td></tr>
		<tr><td>Address:</td><td><input type="text" name="address" value="${profile.address}" maxlength= "20"/> </td></tr>
		<tr><td>Credit Number:</td><td><input type="text" name="credit" value="${profile.credit}" maxlength= "8"/> </td></tr>
		</table>
		<p><input type="submit" value="register"></p>
	</form>
	
	<p><a href="login">Login</a></p>
</body>
</html>