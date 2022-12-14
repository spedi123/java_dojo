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
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the Dog Emporium!</h1>
	
	<h2>Here are the dogs that are available</h2>
	<table class="table table-striped">
		<thead class="table-dark">
			<tr scope="row">
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Hair Color</th>
				<th>Created At</th>
				<th>Updated At</th>
				<th>Action</th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach var="dog" items="${listOfDogs}">
				<tr scope="row">
					<td><c:out value="${dog.id}"/></td>
					<td><c:out value="${dog.name}"/></td>
					<td><c:out value="${dog.age}"/></td>
					<td><c:out value="${dog.hairColor}"/></td>
					<td><fmt:formatDate type="date" value="${dog.createdAt}"/></td>
					<td>
						<c:choose>
							<c:when test="${dog.updatedAt != null }">
								<fmt:formatDate type="date" value="${dog.createdAt}"/>
							</c:when>
							<c:otherwise>
								Dog has not be updated
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						 <a href="/dogs/${ dog.id }" class="btn btn-primary">View</a>
						 <a href="/dogs/${ dog.id }/edit" class="btn btn-warning">Update</a>
						 <form action="/dogs/${ dog.id }/delete" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete" class="btn btn-danger">
						</form>
					</td>
				</tr>
			</c:forEach> 
		</tbody>
	</table>
	<a href="/dogs/new" class="btn btn-success">Create a new Dog!</a>
	<a href="/toys" class="btn btn-outline-primary">Go to the Toy!</a>
</body>
</html>