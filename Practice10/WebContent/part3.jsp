<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<center>
		<a style="font-size: 35px;"><strong>PART3</strong></a> </br>
		<form action="part3" method="post">
			<input type="text" name="myname"> <input type="submit">
		</form>
		<h1>${sessionScope.get("names")}</h1>
		<a style="font-size: 50px;" href="part3?remove=true">remove</a> <br>
		<br>
		<br> <a style="font-size: 50px;" href="part1.jsp"> Перейти к
			Part1</a> <a style="font-size: 50px;" href="part2.jsp"> || Перейти к
			Part2</a> <a style="font-size: 50px;" href="part4.jsp"> || Перейти к
			Part4</a>
	</center>
</body>
</html>