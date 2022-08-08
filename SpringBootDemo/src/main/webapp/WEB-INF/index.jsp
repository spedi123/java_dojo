<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello There</h1>
	<form action="/submit" method="post">
		<p>
			Crust Selection:
			<input type="text" name="crust"/> 
		</p>
		<p>
			Cheese Selection:
			<input type="text" name="cheese"/>
		</p>
		<p>
			Sauce Selection:
			<input type="text" name="sauce"/>
		</p>
		<p>
			Topping Selection:
			<input type="text" name="topping"/>
		</p>
		<button>Order Pizza</button>
	</form>
</body>
</html>