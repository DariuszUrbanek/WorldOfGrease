<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>World of Grease: Edit Products</title>
</head>

<body>
	<h1>OUR PRODUCTS:</h1>

	<c:forEach items="${forms}" var="form">
		<table>
			<tr>
				<td>
					<form:form method="post" action="/editProducts" modelAttribute="${form.prId}">
						<form:hidden path="prId" value="${form.prId}"/>
						<span style="font-weight: bold">Product name:</span>
						<br />
						<form:input path="prName" required="true"></form:input>
						<br />
						<span style="font-weight: bold">Description:</span>
						<br />
						<form:input path="prDescription"></form:input>
						<br />
						<span style="font-weight: bold">Price:</span>
						<br />
						<form:input path="prPrice" required="true"></form:input>
						<br />
						<span style="font-weight: bold">Stock:</span>
						<br />
						<form:input path="prStock" required="true"></form:input>
						<br />
						<input type="submit" value="Save" />
						<br/>
					</form:form></td>
			</tr>
		</table>

	</c:forEach>

</body>

</html>