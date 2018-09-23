<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

	<head>
		<title>World of Grease: Home</title>
	</head>

	<body>
	
		<h1>HOME:</h1>
		<h3 style="color: blue; font-weight: bold">Select action:</h3>
			<a href="/products">Our products</a>
		<br />
			<c:if test="${isAdmin == 'true'}">
				<a href="/addProducts">Add products</a>
			</c:if>
		<br />
			<c:if test="${isAdmin == 'true'}">
				<a href="/editProducts">Edit products</a>
			</c:if>
		<br/>
				
	</body>

</html>