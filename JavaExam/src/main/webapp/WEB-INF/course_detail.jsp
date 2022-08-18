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
	<div class="container mt-5 w-75">
		<h1><c:out value="${oneCourse.className }"/> with <c:out value="${oneCourse.instructor.name }"/></h1>
			<div class="border rounded border-primary p-3 shadow">
				<h3>Days : <c:out value="${ oneCourse.weekDay}"/></h3>
				<h3>Cost : $ <c:out value="${ oneCourse.price}"/></h3>
				<h3>Time : <c:out value="${ oneCourse.time}"/></h3>
				<p><c:out value="${ oneCourse.description}"/></p>
			</div>
	<div class="container">
		<h3>Students</h3>
			<ul>
	       		 <c:forEach var="student" items="${studentsInCourse}">
				 	<li><c:out value="${student.studentName}"/> - <c:out value="${student.email}"/></li>		    		
        		 </c:forEach>
   			</ul>
		</div>		
		<div>
			<h2>Add Students to Course </h2>
			<div class="d-flex">
				<div class="col-1">
					<h3>New Student</h3>
					<form:form action="/courses/${oneCourse.id}/createStudent" method="post" modelAttribute="newStudent">
						<div>
							<form:label class="form-label" path="studnetName">Student Name:</form:label>
							<div>
								<form:errors path="studnetName" class="text-danger"/>
							</div>
							<form:input class="form-control" type="text" path="studnetName"/>
						</div>
						<div>
							<form:label class="form-label" path="email">Email:</form:label>
							<div>
								<form:errors path="email" class="text-danger"/>
							</div>
							<form:input class="form-control" type="text" path="email"/>
						</div>
						<input type="submit" class="btn btn-sm btn-success" value="Save">
					</form:form>
				</div>
				<div class="col-1">
					<h3>Existing Student</h3>
					<form:form action="/courses/${ oneCourse.id}/participateClass" method="post" modelAttribute="student">
		 				<select name="productId" id="productId" class="input">
							<c:forEach var="student" items="${studentsNotInCourse}">
								<option value="${student.id}">${student.studnetName} - ${student.email}</option>
							</c:forEach>
						</select>
						<div>
						    <input type="submit" class="btn btn-sm btn-success" value="Add">
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<a href="/courses" class="btn btn-outline-success">Home</a>		
</body>
</html>