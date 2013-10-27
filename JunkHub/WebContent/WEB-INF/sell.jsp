<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>
<jsp:useBean id="item" class="edu.unsw.triangle.model.Item" scope="request"></jsp:useBean>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sell Item</title>
</head>
<body>
<h1>Sell Item</h1>
<!-- messages -->
<div style="color: #009900;">${messages.getMessage("sell.success")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("title")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("category")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("picture")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("description")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("postage")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("reserve")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("start")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("increment")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("period")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("sell.error")}</div>
<br>
<!-- form -->
<form  method="POST" action="sell" enctype="multipart/form-data">
<table>
	<tr><td>Title:</td><td><input type="text" value="${item.title}" name="title" maxlength="100"></td></tr>
	<tr><td>Category:</td><td><input type="text" value="${item.category}" name="category" maxlength= "100"></td></tr>
	<tr><td>Picture:</td><td><input type="file" name="picture" maxlength= "50" accept="image/gif, image/jpeg, image/jpg, image/png, image/bmp"></td></tr>
	<tr><td>Description:</td><td><input type="text" value="${item.description}" name="description" maxlength= "750"></td></tr>
	<tr><td>Postage:</td><td><input type="text" value="${item.postage}" name="postage" maxlength= "50"></td></tr>
	<tr><td>Reserve Price ($):</td><td><input type="text" value="${item.reserve}" name="reserve" maxlength= "5"></td></tr>
	<tr><td>Start Price ($):</td><td><input type="text" value="${item.start}" name="start" maxlength= "5"></td></tr>
	<tr><td>Bid Increments ($):</td><td><input type="text" value="${item.increment}" name="increment" maxlength= "5"></td></tr>
	<tr><td>Auction Time (min):</td><td><input type="text" value="${item.period}" name="period" maxlength= "2"></td></tr>
</table>
<input type="submit" value="sell" name="sell">
</form>
<!-- navigation -->
<p><a href="main">Back</a></p>
</body>
</html>