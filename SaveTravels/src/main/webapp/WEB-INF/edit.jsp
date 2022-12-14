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
<h1>Edit Expense:</h1>
<a href="/expenses">Go back</a>
<form:form action="/expenses/${expense.id}/edit" method="post" modelAttribute="expense">
<input type="hidden" name="_method" value="put">
	<div>
		<form:label path="name">Expense Name: </form:label><br />
		<form:errors path="name"/>
		<form:input path="name"/>
	</div>

	<div>
		<form:label path="vendor">Vendor: </form:label><br />
		<form:errors path="vendor"/>
		<form:input  path="vendor"/>
	</div>
	
	<div>
		<form:label path="amount">Amount: </form:label><br />
		<form:errors path="amount"/>
		<form:input type="double" path="amount"/>
	</div>
	
	<div>
		<form:label path="description">Description: </form:label><br />
		<form:errors path="description"/>
		<form:textarea style="width:250px;" rows="3" path="description"/>
	</div>
	
	<div>
		<input type="submit" value="Submit"/>
	</div>
	
	

</form:form>
</div>
</body>
</html>