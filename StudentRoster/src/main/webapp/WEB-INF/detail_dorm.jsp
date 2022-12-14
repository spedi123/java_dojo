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
		<div>
			<h1>${dorms.name} Students</h1>
		</div>
		<div>
			<a href="/dorms">Dashboard</a>
		</div>
		<div>
			<form:form action="/students/update/${dorms.id}" method="post" modelAttribute="student">
			<input type="hidden" name="_method" value="put" />
				<div>
					<form:hidden path="dorm"/>
					<form:hidden path="name"/>
					<form:label path="id">Students:</form:label>
					<form:select path="id">
						<c:forEach var="student" items="${listOfStudents}">
							<option value="${student.id}">${student.name} (${student.dorm.name})</option>
						</c:forEach>
					</form:select>
				</div>		
				<input type="submit" value="Add"/>
			</form:form>
		</div>
		<div class="m-5 p-5 shadow rounded">
			<table>
				<thead>
					<tr>
						<th>Student</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${dorms.students}">
						<tr>
							<td><c:out value="${student.name}"/></td>
							<td><form:form action="/students/${dorms.id}/${student.id}" method="POST">
								<input type="hidden" name="_method" value="PUT" />
								<input type="submit" value="Remove"/>
								</form:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>