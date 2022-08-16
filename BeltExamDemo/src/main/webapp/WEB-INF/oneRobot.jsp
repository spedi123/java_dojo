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
	<h1>Here is infor about this robot</h1>
	<p>Name : <c:out value="${oneRobot.name}"/></p>
	<p>Weapon : <c:out value="${oneRobot.weapon}"/></p>
	<p>color : <c:out value="${oneRobot.color}"/></p>
	<p>Is Evil? : <c:out value="${oneRobot.evil}"/></p>
	<p>Creator : <c:out value="${oneRobot.creator.firstName}"/></p>
	<a href="/robots">Dashboard</a>
	<c:if test="${ oneRobot.creator.id == loggedInUser.id }">
		<a href="/robots/${ oneRobot.id }/edit">Edit</a>
		<form action="/robots/${ oneRobot.id }/delete" method="post">
			<input type="hidden" name="_method" value="delete"/>
			<button class="btn btn-outline-danger">Delete this robot</button>
		</form>
	</c:if>
</body>
</html>










