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
<h1>${item.title}</h1>
<!-- messages here -->
<div style="color: #FF0000;">${errors.getErrorMessage("request")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("bid")}</div>
<div style="color: #FF0000;">${errors.getErrorMessage("id")}</div>
<br>

<p><img src="../images/${item.picture}" alt="${item.picture}" width="200" height="150"></p>
<table>
<tr><td>Category</td><td>${item.category}</td></tr>
<tr><td>Description</td><td>${item.description}</td></tr>
<tr><td>Seller</td><td>${item.owner}</td></tr>
<tr><td>Postage</td><td>${item.postage}</td></tr>
<tr><td>Starting Bid</td><td>$${item.start}</td></tr>
<tr><td>Current Bid</td><td>$${item.bid} ${item.bidder}</td></tr>
<tr><td>Time Left</td>
<c:choose>
	<c:when test="${item.timeLeft >= 0}">
	<td>${item.timeLeft} mins</td>
	</c:when>
	<c:otherwise>
	<td><div style="color: #FF0000;">Expired</div></td>
	</c:otherwise>
</c:choose>
</tr>
</table>
<br>
<c:choose>
  <c:when test="${websession.profile.admin}"><div style="color: #FF0000;">admin cannot place bids</div></c:when>
  <c:when test="${item.owner eq websession.username and item.status eq 'PENDING'}">
  <div style="color: #FF9900;">item pending</div>
  accept?
  </c:when>
  <c:when test="${item.owner eq websession.username}"><div style="color: #FF0000;">owner of item cannot place bids</div></c:when>
  <c:when test="${item.status eq 'PENDING'}"><div style="color: #FF9900;">item pending</div></c:when>
  <c:when test="${item.status eq 'SOLD'}"><div style="color: #009900;">item sold</div></c:when>
  <c:when test="${item.status eq 'UNSOLD'}"><div style="color: #FF0000;">item unsold</div></c:when>
  <c:when test="${item.status eq 'NOT_ACTIVE'}"><div style="color: #FF0000;">item suspended</div></c:when>
  <c:otherwise>
  <form  method="POST" action="item">
  	<div style="color: #009900;">item active</div>
  	<p><label>bid increments of $${item.increment}</label></p>
	<input type="text" name="bid" maxlength= "5">
	<input type="hidden" name="id" value="${item.id}"> 
  	<input type="submit" value="bid" name="Place Bid">
  </form>
  </c:otherwise>
</c:choose>
<p><a href="main">return to main</a></p>
</body>
</html>