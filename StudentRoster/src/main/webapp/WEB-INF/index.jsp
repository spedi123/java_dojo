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
	<h1 class="text-center">Dorms</h1>
	<div>
		<a href="/dorms/new">Add a new dorm</a>
	</div>
	<div>
		<a href="/students/new">Add a new student</a>
	</div>

		<table class="table table-striped ">
			<thead>
				<tr>
					<th>Dorm</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dorm" items="${dorms}">
					<tr>
						<td><c:out value="${dorm.name}"/></td>
						<td><a href="/dorms/${dorm.id}">See Students</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>