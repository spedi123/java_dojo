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
		<h1 class="text-center">New Category</h1>
		<a href="/">Home</a>
		 <div>
	    	<div>
				<form:form action="/categories/new" method="post" modelAttribute="category">
					<div class="mb-3">
						<form:label class="form-label" path="name">Name:</form:label>
						<form:errors path="name" class="text-danger"/>
						<form:input class="form-control" type="text" path="name"/>
					</div>
					<input class="btn btn-outline-success p-2" type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>