<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>Send an Omikuji!</h1>
	</div>
	<div class="container">
		<form action="/submit" method="post">
			<p>
				Pick any number from 5 to 25 :
				<select name="number" id="number">
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
				</select>
			</p>
			<p>
				Enter the name of any city 
				<input type="text" name="city"/>
			</p>
			<p>
				Enter the name of any real person
				<input type="text" name="name"/>
			</p>
			<p>
				Enter professional endeavor or hobby
				<input type="text" name="endeavor"/>
			</p>
			<p>
				Enter the any tpye of living thing
				<input type="text" name="type"/>
			</p>
			<p>
				Say something nice to someone:
				<textarea name="comment" id="comment" cols="30" rows="10"></textarea>
			</p>
			<p> Send and show a friend</p>
			<button>Send</button>
		</form>
	</div>
</body>
</html>