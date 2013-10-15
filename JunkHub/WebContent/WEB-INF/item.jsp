<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="errors" class="edu.unsw.triangle.util.Errors" scope="request"></jsp:useBean>
<jsp:useBean id="item" class="edu.unsw.triangle.model.Item" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${item.title}</title>
</head>
<body>


<div style="color: #FF0000;">${errors.getErrorMessage("request")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("bid")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("id")}</div>


<h1>${item.title}</h1>
<p>${item.category}</p>
<p>${item.description}</p>
<p>${item.postage}</p>
<p>${item.start}</p>
<p>${item.bid}</p>
<p>${item.owner}</p>
<p>${item.bidder}</p>
<p>${item.timeLeft}</p>
<form  method="POST" action="item">
<input type="text" name="bid" maxlength= "5"><br>
<input type="hidden" name="id" value="${item.id}"/> 
<input type="submit" value="bid" name="place bid">
</form>
<a href="main">return to main</a>
<a href="main.back">back</a>
</body>
</html>