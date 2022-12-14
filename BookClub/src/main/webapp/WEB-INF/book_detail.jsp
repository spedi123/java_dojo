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
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<title>Read Share</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>${book.title}</h1>
		</div>
		<a href="/logout">Logout</a>
		<a href="/books">Back to the shelves</a>
		<div>
			<h3>${book.user.user_name} read ${book.title} by ${book.author}.</h3>
			<h4>Here are ${book.user.user_name}'s thoughts:</h4>
			<div>
				<p>${book.thought}</p>
			</div>
		</div>
		<c:if test="${user.id == book.user.id }">
			<a class="btn btn-success" href="/books/edit/${book.id}">Edit</a>
		</c:if>
		
	</div>
</body>
</html>