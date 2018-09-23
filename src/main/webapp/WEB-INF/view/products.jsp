<!DOCTYPE html>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

	<head>
		<title>World of Grease: Products</title>
	</head>

	<body>
		<h1>OUR PRODUCTS:</h1>
		
		<c:forEach items="${list}" var="product">
		
		<table>
			<tr>
				<td>
					Product: <b><c:out value="${product.prName}"/></b>
					<br/> 
					Description: <b><c:out value="${product.prDescription}"/></b>
					<br/> 
					Price: <b><c:out value="${product.prPrice}"/>$</b>
					<br/>  
					In stock: <b><c:out value="${product.prStock}"/></b>
					<br/><br/>  
				</td>
			</tr>			
		</table>
		
		</c:forEach>

	</body>

</html>