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
username: ${profile.username}
firstname: 
<input type="text" value="${profile.firstname}" name="username"><br>
lastname:
<input type="text" value="${profile.lastname}" name="firstname"><br>
dob: ${profile.dob}<br>
<input type="text" value="${profile.dob}" name="dob"><br>
email: ${profile.email}<br>
<input type="text" value="${profile.email}" name="email"><br>
address: ${profile.address}<br>
<input type="text" value="${profile.address}" name="address"><br>
<input type="submit" value="save" name="update"><br>
</form>

<a href="main">Go back to Main</a>
</body>
</html>