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
		<h1>Change your Entry</h1>
		<a href="/logout">Logout</a>
		<a href="/books">Back to the shelves</a>

		<form:form action="/books/edit/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put">
			<div class="mb-3">
				<form:label class="form-label" path="title">Title:</form:label>
				<div>
					<form:errors path="title" class="text-danger"/>
				</div>
				<form:input class="form-control" type="text" path="title"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="author">Author:</form:label>
				<div>
					<form:errors path="author" class="text-danger"/>
				</div>
				<form:input class="form-control" type="text" path="author"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="thought">My Thoughts:</form:label>
				<div>
					<form:errors path="thought" class="text-danger"/>
				</div>
				<form:textarea class="form-control" path="thought"/>
			</div>
			<form:input type="hidden" path="user" value="${book.user.id}" />
			<input class="btn btn-outline-success p-2" type="submit" value="Submit" />
		</form:form>
	</div>
	
</body>
</html>