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
		<h1>Welcome ${user.user_name}</h1>
		<a href="/logout">Logout</a>
		<h3>Books from everyone's shelves</h3>
		<a href="/books/new">Add to my shelf</a>
		<a href="/bookrent">Rent a book</a>
		<table class="table table-striped">
			<thead class="table-dark">
				<tr scope="row">
					<th> ID </th>
					<th> Title </th>
					<th> Author Name </th>
					<th> Posted By </th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr scope="row">
						<td><c:out value= "${book.id}"/></td>
						<td><a href="/books/${book.id}"><c:out value= "${book.title}"/></a></td>
						<td><c:out value= "${book.author}"/></td>
		 				<td><c:out value= "${book.user.user_name}"/></td>					
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</body>
</html>