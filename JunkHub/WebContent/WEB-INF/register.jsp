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
Register
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
	<form method="POST" action="register">
		Username <input type="text" name="username" value="${profile.username}"/><br>
		Password <input type="password" name="password" value="${profile.password}" /><br>
		Nickname <input type="text" name="nickname" value="${profile.nickname}"/><br>
		Email address <input type="text" name="email" value="${profile.email}"/><br>
		First name <input type="text" name="firstname" value="${profile.firstname}"/><br>
		Last name <input type="text" name="lastname" value="${profile.lastname}"/><br>
		Date of birth <input type="text" name="dob" value="${profile.dob}"/><br>
		Address <input type="text" name="address" value="${profile.address}"/><br>
		Credit card number <input type="text" name="credit" value="${profile.credit}"/><br>
		<input type="submit" value="register">
	</form>
	<a href="login">Login</a>
</body>
</html>