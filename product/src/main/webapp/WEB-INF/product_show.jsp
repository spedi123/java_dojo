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
		<h1 class="text-center"><c:out value="${product.name}"/></h1>
		<a href="/">Home</a>
		<div>
			<h2>Categories : </h2>
			<ul>
	       		 <c:forEach var="category" items="${assignedCategories}">
				 	<li><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></li>		    		
        		 </c:forEach>
   			</ul>
		</div>		
		<div>
			<h2>Add Category : </h2>
			<form:form action="/products/${product.id}" method="post" modelAttribute="category">
 				<select name="categoryId" id="categoryId" class="input">
					<c:forEach var="category" items="${unassignedCategories}">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
				<div>
				    <input type="submit" class="btn btn-sm btn-success" value="Add">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>