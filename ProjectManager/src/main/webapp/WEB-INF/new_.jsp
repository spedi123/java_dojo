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
<title>Create robot!</title>
</head>
<body>
<%-- 	<h1>Add a new Robot</h1>
	<form:form action="/robots/create" method="post" modelAttribute="newRobot">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		<p>
			<form:label path="weapon">Weapon</form:label>
			<form:input path="weapon"/>
			<form:errors path="weapon"/>
		</p>
		<p>
			<form:label path="color">Color</form:label>
			<form:input path="color"/>
			<form:errors path="color"/>
		</p>
		<p>
			<form:label path="evil">Is evil?</form:label>
			<form:checkbox path="evil" value="true"/>
			<form:errors path="evil"/>
		</p> 
		<button class="btn btn-danger">Add Robot</button>
	</form:form>
	<a href="/robots">Cancel</a> --%>
</body>
</html>







