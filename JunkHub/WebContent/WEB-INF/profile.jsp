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
<form method="POST" action="profile">
username:
<input type="text" value="${profile.username}" name="username">
<input type="submit" value="update" name="update"><br>
</form>
firstname: ${profile.firstname}<br>
lastname: ${profile.lastname}<br>
dob: ${profile.dob}<br>
email: ${profile.email}<br>
address: ${profile.address}<br>
<a href="main">Go back to Main</a>
</body>
</html>