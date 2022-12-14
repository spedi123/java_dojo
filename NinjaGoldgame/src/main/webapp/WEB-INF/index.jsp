<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
	<div class="header text-center">
		<h2>Your gold : <c:out value="${gold}"/></h2>
	</div>
	<div class="container d-flex">
		<div class="farm">
			<h3>Farm</h3>
			<p>(earns 10~20 gold)</p>
			<form action="/gold" method="post">
			<button type="submit" name="farm" value="farm">Find Gold!</button>
			</form>
		</div>
		<div class="cave">
			<h3>Cave</h3>
			<p>(earns 5~10 gold)</p>
			<form action="/gold" method="post">
			<button type="submit" name="cave" value="cave">Find Gold!</button>
			</form>
		</div>
		<div class="house">
			<h3>House</h3>
			<p>(earns 2~5 gold)</p>
			<form action="/gold" method="post">
			<button type="submit" name="house" value="house">Find Gold!</button>
			</form>
		</div>
		<div class="quest">
			<h3>Quest</h3>
			<p>(earns/takes 0~50 gold)</p>
			<form action="/gold" method="post">
			<button type="submit" name="quest" value="quest">Find Gold!</button>
			</form>
		</div>
	</div>
	<div class="activity">
		<h2>Activities</h2>
		<div class="activeDetail"></div>
	</div>
</body>
</html>