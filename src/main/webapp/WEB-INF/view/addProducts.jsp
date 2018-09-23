<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%   String number = request.getParameter( "empNo" );   session.setAttribute( "theName", number );%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

      <head>
        <title>World of Grease: Add Products</title>
      </head>

      <body>  
      
        <form:form method="post" action="/addProducts" modelAttribute="form">
          <h2>Product details:</h2>
          <br/>
          <span style="font-weight:bold">Product name:</span>
          <br/>       
          <form:input path="prName" required="true"></form:input>
          <br/>
          <span style="font-weight:bold">Description:</span><br/>         
          <form:input path="prDescription"></form:input>
          <br/>
          <span style="font-weight:bold">Price:</span><br/>          
          <form:input path="prPrice" required="true"></form:input>
          <br/>
          <span style="font-weight:bold">Stock:</span><br/>          
          <form:input path="prStock" required="true"></form:input>
          <br/>
          <br/>
          <input type="submit" value="Save" />
        </form:form>
      </body>

      </html>