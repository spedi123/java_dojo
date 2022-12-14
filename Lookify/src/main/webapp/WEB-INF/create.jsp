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
<title>Add New Song</title>
</head>
<body>
	<div>
		<form:form action="/songs/new" method="post" modelAttribute="song">
			<div>
				<form:label path="title">Title: </form:label><br />
				<form:errors path="title"/>
				<form:input path="title"/>
			</div>
		
			<div>
				<form:label path="artist">Artist: </form:label><br />
				<form:errors path="artist"/>
				<form:input  path="artist"/>
			</div>
			
			<div>
				<form:label path="rating">Rating (1~10) : </form:label><br />
				<form:errors path="rating"/>
				<form:input type="number" path="rating"/>
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="Submit"/>
			</div>
		</form:form>
	</div>
</body>
</html>