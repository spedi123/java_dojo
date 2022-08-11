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
   	 <h2>Here is: <c:out value="${ dog.name }" />!</h2>
   	 <p><c:out value="${ dog.name }" /> is: <c:out value="${ dog.age }" /></p>
   	 <p><c:out value="${ dog.name }" /> is: <c:out value="${ dog.hairColor }" /></p>
   	 <a href="/dogs" class="btn btn-primary">Dashboard</a>
	 <a href="/dogs/${ dog.id }/edit" class="btn btn-warning">Update</a>
	 <form action="/dogs/${ dog.id }/delete" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete" class="btn btn-danger">
	</form>
</body>
</html>