<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
</head>
<body>
<h1>My Profile</h1>
<!-- messages -->
<div style="color: #009900;">${messages.getMessage("profile.success")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("profile.error")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("password")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("email")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("firstname")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("lastname")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("nickname")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("address")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("dob")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("credit")}</div>
<br>
<!-- form -->
<h2>${profile.username}</h2>
<form method="POST" action="profile">
<input type="hidden" name="username" value="${profile.username}"/>
<table>
	<tr><td>Password:</td><td><input type="password" name="password" value="${profile.password}" maxlength= "20"></td></tr>
	<tr><td>Nickname:</td><td><input type="text" name="nickname" value="${profile.nickname}" maxlength= "20"></td></tr>
	<tr><td>Email:</td><td><input type="text" name="email" value="${profile.email}" maxlength= "100"></td></tr>
	<tr><td>First Name:</td><td><input type="text" name="firstname" value="${profile.firstname}" maxlength= "20"/></td></tr>
	<tr><td>Last Name:</td><td><input type="text" name="lastname" value="${profile.lastname}" maxlength= "20"/> </td></tr>
	<tr><td>DOB dd/mm/yyy:</td><td><input type="text" name="dob" value="${profile.dob}" maxlength= "10"/> </td></tr>
	<tr><td>Address:</td><td><input type="text" name="address" value="${profile.address}" maxlength= "50"/> </td></tr>
	<tr><td>Credit Number:</td><td><input type="text" name="credit" value="${profile.credit}" maxlength= "8"/> </td></tr>
</table>
<input type="submit" value="save" name="update">
</form>

<p><a href="main">Go back to Main</a></p>
</body>
</html>