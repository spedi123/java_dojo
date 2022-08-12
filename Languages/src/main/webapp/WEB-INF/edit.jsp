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
<title>Program Languages</title>
</head>
<body>
<h2>Edit</h2>
<a href="/languages/${language.id}/delete">Delete</a>
<a href="/languages">Dashboard</a>
   	<form:form action="/languages/${ language.id }/edit" method="post" modelAttribute="language" class="form">
   		<input type="hidden" name="_method" value="put">
   		<p>
   			<form:label path="name">Name:</form:label>
   			<form:input path="name" />
   			<form:errors path="name" />
   		</p>
   		<p>
   			<form:label path="creator">Creator:</form:label>
   			<form:input path="creator" />
   			<form:errors path="creator" />
   		</p>
   		<p>
   			<form:label path="currentVersion">Version:</form:label>
   			<form:input type="double" path="currentVersion" />
   			<form:errors path="currentVersion" />
   		</p>
   		<button class="btn btn-outline-success">Update</button>
   	</form:form>
   	
   	<a href="/languages">Cancel</a>
</body>
</html>