<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
<h1>Error, opps something bad has happened</h1>
<div style="color: #FF0000;">${errors.getErrorMessage("error")}</div>
<!-- navigation -->
<p><a href="main">Main</a></p>
</body>
</html>