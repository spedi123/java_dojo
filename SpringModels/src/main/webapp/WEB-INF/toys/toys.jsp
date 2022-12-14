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
	<div class="container d-flex justify-content-between align-items-center mb-3">
		<h1>Welcome to the toy market!</h1>
		<a href="/dogs">Dashboard</a>
	</div>
	<div class="container d-flex justify-content-between gap-3">
		<div class="col-6 border border-dark p-3">
			<h2>Available toys:</h2>
			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>Name</th>
						<th>Color</th>
						<th>Is Squeaky</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneToy" items="${ allToys }">
						<tr>
							<td><c:out value="${ oneToy.name }" /></td>
							<td><c:out value="${ oneToy.color }" /></td>
							<td><c:out value="${ oneToy.isSqueaky }" /></td>
							<td><c:out value="${ oneToy.dog.name }" /></td>
							<td>
								<a href="/toys/${ oneToy.id }">View</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-6 border border-dark p-3">
			<h2>Sell your toy:</h2>
			<form:form action="/toys/create" method="post" modelAttribute="newToy">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:input path="name" />
					<form:errors path="name" />
				</div>
				<div class="form-group">
					<form:label path="color">Color:</form:label>
					<form:input path="color" />
					<form:errors path="color" />
				</div>
				<div class="form-group">
					<form:label path="isSqueaky">Is Squeaky?</form:label>
					<form:checkbox path="isSqueaky"/>
					<form:errors path="isSqueaky" />
				</div>
				<div class="form-group">
					<form:select path="dog">
						<c:forEach var="oneDog" items="${ allDogs }">
							<form:option  value="${ oneDog.id }"><c:out value="${ oneDog.name }" /></form:option>
						</c:forEach>
					</form:select>
				</div>
				<button class="btn btn-outline-success">Add Toy</button>
			</form:form>
		</div>
	</div>
</body>
</html>