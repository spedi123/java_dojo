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
	<table class="table table-striped mb-10">
	    <thead>
	        <tr>
	            <th class="text-center">Name</th>
	            <th class="text-center">Creator</th>
	            <th class="text-center">Version</th>
	            <th class="text-center">Action</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach var="lang" items="${languages}">
				<tr>
					<td class="text-center"><a href="/languages/${ lang.id }"><c:out value="${lang.name}"></c:out></a></td>
					<td class="text-center"><c:out value="${lang.creator}"></c:out></td>
					<td class="text-center"><c:out value="${lang.currentVersion}"></c:out></td>
					<td class="text-center">
						<a href="/languages/${lang.id}/edit">Edit</a>
						<form action="/languages/${lang.id}/delete" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>	
			</c:forEach>
	    </tbody>
	</table>
	<div>
		<form:form action="/languages" method="post" modelAttribute="language">
			<div>
				<form:label path="name">Name: </form:label><br />
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
		
			<div>
				<form:label path="creator">Creator: </form:label><br />
				<form:errors path="creator"/>
				<form:input  path="creator"/>
			</div>
			
			<div>
				<form:label path="currentVersion">Version: </form:label><br />
				<form:errors path="currentVersion"/>
				<form:input type="double" path="currentVersion"/>
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="Submit"/>
			</div>
		</form:form>
	</div>
</body>
</html>