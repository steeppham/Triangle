<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>
<jsp:useBean id="item" class="edu.unsw.triangle.model.Item" scope="request"></jsp:useBean>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Sell Item</h1>
<div style="color: #FF0000;">${errors.getErrorMessage("title")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("category")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("picture")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("postage")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("reserve")}</div>

<form  method="POST" action="sell">
<label>title</label>
<input type="text" value="${item.title}" name="title"><br>
<label>category</label>
<input type="text" value="${item.category}" name="category"><br>
<label>picture</label>
<input type="file" value="${item.picture}" name="picture"><br>
<label>postage</label>
<input type="text" value="${item.postage}" name="postage"><br>
<label>reserve price</label>
<input type="text" value="${item.reserve}" name="reserve"><br>
<label>start price</label>
<input type="text" value="${item.startPrice}" name="start"><br>
<label>bid increments</label>
<input type="text" value="${item.bidIncrement}" name="increments"><br>
<input type="submit" value="sell" name="sell">
</form>
</body>
</html>