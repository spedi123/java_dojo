<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <title></title>
</head>
<body>
    <h1>Dog Emporium!</h1>
   	<h2>Edit <c:out value="${ dog.name }" /></h2>
   	<form:form action="/dogs/${ dog.id }/update" method="post" modelAttribute="dog" class="form">
   		<input type="hidden" name="_method" value="put">
   		<p>
   			<form:label path="name">Name:</form:label>
   			<form:input path="name" />
   			<form:errors path="name" />
   		</p>
   		<p>
   			<form:label path="age">Age:</form:label>
   			<form:input type="number" path="age" />
   			<form:errors path="age" />
   		</p>
   		<p>
   			<form:label path="hairColor">Hair Color:</form:label>
   			<form:input path="hairColor" />
   			<form:errors path="hairColor" />
   		</p>
   		<button class="btn btn-outline-success">Edit this dog!</button>
   	</form:form>
   	
   	<a href="/dogs">Cancel</a>
</body>
</html>