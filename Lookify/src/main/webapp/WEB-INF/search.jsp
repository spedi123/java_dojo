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
<title>Search</title>
</head>
<body>
	<div class="text-center">
		<p>Songs by artist : <c:out value="${ artist }"/></p>
	    <form method="post" action="/songs/search">
		    <input type="search" placeholder="Search your Artist!" name="artist">
		    <button class="btn btn-success" type="submit">Search</button>
	    </form>
	    <a href="/songs">Dashboard</a>
	</div>
	<table class="table table-striped mb-10">
	    <thead>
	        <tr>
	            <th class="text-center">Name</th>
	            <th class="text-center">Rating</th>
	            <th class="text-center">Action</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach var="song" items="${songs}">
				<tr>
					<td class="text-center"><a href="/songs/${ song.id }"><c:out value="${song.title}"></c:out></a></td>
					<td class="text-center"><c:out value="${song.rating}"></c:out></td>
					<td class="text-center">
						<form action="/songs/delete/${song.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>	
			</c:forEach>
	    </tbody>
	</table>
</body>
</html>