<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="profile" class="edu.unsw.triangle.model.Profile" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm</title>
</head>
<body>
<h1>Confirm Registration</h1>
<!-- error messages -->
<div style="color: #FF0000;">${errors.getErrorMessage("confirm.error")}</div>
<div style="color: #009900;">${messages.getMessage("confirm.success")}</div>
<br>
<a href="login">go to login</a>
</body>
</html>