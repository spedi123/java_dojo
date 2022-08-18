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
	<div class="d-flex container">
		<div class="col1">
			<h1>New Dojo</h1>
			<form:form action="/dojos/new" method="post" modelAttribute="dojo">
				<div class="mb-3">
					<form:label path="name">Name :</form:label>
					<div>
						<form:errors path="name"/>
					</div>
					<form:input type="name" path="name" id="name" />
				</div>
				<input class="btn btn-success" type="submit" value="Create" />
			</form:form>
		</div>
		<div class="col1">
			<table class="table table-striped">
			    <thead>
			        <tr>
			            <th>Dojo Name</th>
			        </tr>
			    </thead>
			    <tbody>
			         <c:forEach var="dojo" items="${dojos}">
			         	<tr>
			         		<td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
			         	</tr>
			         </c:forEach>
			    </tbody>
		    </table>
		</div>
	</div>
</body>
</html>