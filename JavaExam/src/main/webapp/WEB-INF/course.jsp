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
	<div class="container mt-5">
		<h1>Namaste, <c:out value="${loggedInUser.name}"/></h1>
		<a href="/logout">Logout</a>
		<div class="row">
			<h3>Course Schedule</h3>
		</div>
		<table class="table table-hover table-striped mb-5 shadow">
		    <thead>
		        <tr>
		            <th>Class Name</th>
		            <th>Instructor</th>
		            <th>Weekday</th>
		            <th>Price</th>
		            <th>Time</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="course" items="${allcourses}">
		         	<tr>
		         		<td>
		         			<a href="/courses/${course.id}"><c:out value="${course.className}"/></a>
	         				<c:if test="${ loggedInUser.id == course.instructor.id }">
								<a class="btn btn-success" href="/courses/${course.id}/edit">Edit</a>
							</c:if>
		         			</td>
		         		<td><c:out value="${course.instructor.name}"/></td>
		         		<td><c:out value="${course.weekDay}"/></td>
		         		<td>$ <c:out value="${course.price}"/></td>
		         		<td><c:out value="${course.time}"/></td>
		         	</tr>
		         </c:forEach>
		    </tbody>
	    </table>
	    
	    <a href="/courses/new" class="btn"> + new course</a>
	</div>
</body>
</html>