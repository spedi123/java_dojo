<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>

<!-- for Form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Login</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>

<body class="bg-dark text-light p-4">
	<div class="container-fluid">
		<h1 class="text-primary">Joy Bundler Names</h1>
	</div>
	<!-- !!! REGISTER FORM !!! -->
	<div class="container-fluid d-flex flex-row">
		<form:form action="/register" method="post" modelAttribute="newUser"
			class="col-6">
			<p class="fs-2">Register</p>
			<p>
				<form:label class="form-label" path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input class="form-control w-50" path="name" />
			</p>
			<p>
				<form:label class="form-label" path="email">Email:</form:label>
				<form:errors path="email" />
				<form:input class="form-control w-50" path="email" />
			</p>
			<p>
				<form:label class="form-label" path="password">Password:</form:label>
				<form:errors path="password" />
				<form:password class="form-control w-50" path="password" />
			</p>
			<p>
				<form:label class="form-label" path="confirmPassword">Confirm Password:</form:label>
				<form:errors path="confirmPassword" />
				<form:password class="form-control w-50" path="confirmPassword" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>

		<!-- !!! LOGIN FORM !!! -->
		<form:form action="/login" method="post" modelAttribute="loginUser"
			class="col-6">
			<p class="fs-2">Login</p>
			<p>
				<form:label class="form-label" path="email">Email:</form:label>
				<form:errors path="email" />
				<form:input class="form-control w-50" path="email" />
			</p>
			<p>
				<form:label class="form-label" path="password">Password:</form:label>
				<form:errors path="password" />
				<form:password class="form-control w-50" path="password" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>