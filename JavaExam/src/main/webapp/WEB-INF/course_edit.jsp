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
	<div class="container">
		<h1><c:out value="${ course.className }"/></h1>
		<div>
			<form:form action="/courses/${ course.id }/update" method="post" modelAttribute="course">
			<input type="hidden" name="_method" value="put">
				<div>
					<form:label class="form-label" path="className">Name:</form:label>
					<div>
						<form:errors path="className" class="text-danger"/>
					</div>
					<form:input class="form-control" type="text" path="className"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="weekDay">Day of Week:</form:label>
					<div>
						<form:errors path="weekDay" class="text-danger"/>
					</div>
					<form:input class="form-control" type="text" path="weekDay"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="price">Drop-in-Price:</form:label>
					<div>
						<form:errors path="price" class="text-danger"/>
					</div>
					<form:input type="number" step="0.01" class="form-control" path="price"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="time">Time:</form:label>
					<div>
						<form:errors path="time" class="text-danger"/>
					</div>
					<form:input type="time" class="form-control" path="time"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="description">Description:</form:label>
					<div>
						<form:errors path="description" class="text-danger"/>
					</div>
					<form:textarea class="form-control" path="description"/>
				</div>
				<a href="/courses" class="btn btn-outline-success">Cancel</a>
				<input class="btn btn-outline-success" type="submit" value="Update" />
			</form:form>
			<form action="/courses/${ course.id }/delete" method="post">
				<input type="hidden" name="_method" value="delete"/>
				<button class="btn btn-outline-danger">Delete</button>
			</form>
		</div>
	</div>
</body>
</html>