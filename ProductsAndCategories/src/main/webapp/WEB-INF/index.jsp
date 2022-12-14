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
		<h1 class="text-center">Home Page</h1>
		<a href="/products/new">New Product</a>
		<a href="/categories/new">New Category</a>
		<div>
			<table class="table table-hover table-striped">
			    <thead>
			        <tr>
			            <th>Products</th>
			            <th>Categories</th>
			        </tr>
			    </thead>
			    <tbody>
			    	<tr>
			    		<td>
			    			<ul>
			        		 <c:forEach var="product" items="${products}">
       							<li><a href="/products/${product.id}"><c:out value="${product.name}"/></a></li>		    		
			         		 </c:forEach>
			    			</ul>
			    		</td>
			    		<td>
			    			<ul>
			        		 <c:forEach var="category" items="${categories}">
       							<li><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></li>		    		
			         		 </c:forEach>
			    			</ul>
			    		</td>
			  		</tr>
			    </tbody>
		    </table>
		 </div>
	</div>
</body>
</html>