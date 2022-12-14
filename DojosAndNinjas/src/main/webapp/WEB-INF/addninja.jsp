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
	<div>
		<h1>New Ninja</h1>
		<div>
			<form:form action="/ninjas/new" method="post" modelAttribute="newNinja">
			 	<div>
				<form:label path="dojo">Dojo:</form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${dojos}">
		         		<option value="${dojo.id}">${dojo.name}</option>
		       	  	</c:forEach>
				</form:select>
				</div>
				<div>
					<form:label path="firstName">First Name:</form:label>
					<div>
						<form:errors path="firstName"/>
					</div>
					<form:input type="text" path="firstName"/>
				</div>
				<div>
					<form:label path="lastName">Last Name:</form:label>
					<div>
						<form:errors path="lastName"/>
					</div>
					<form:input type="text" path="lastName"/>
				</div>
				<div>
					<form:label path="age">Age:</form:label>
					<div>
						<form:errors path="age"/>
					</div>
					<form:input type="number" path="age"/>
				</div>
				<input class="btn btnsuccess" type="submit" value="Create" />
			</form:form>
		</div>
		<a href="/dojos">Dashboard</a>
	</div>
</body>
</html>