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
		<a style="font-size: 35px;"><strong>ТАБЛИЦА УМНОЖЕНИЯ,
				ИСПОЛНЕННАЯ С ПОМОЩЬЮ JSTL</strong></a> </br>
		</br> </br>
		</br>
		<table border="5" style="font-size: 50px;">
			<tr>
				<td></td>
				<c:forEach begin="1" end="9" var="x">
					<td>${x}</td>
				</c:forEach>
			</tr>

			<c:forEach begin="1" end="9" var="i">
				<td>${i}</td>
				<c:forEach begin="1" end="9" var="j">
					<td>${i*j}</td>
				</c:forEach>
				<tr></tr>
			</c:forEach>

		</table>
		<a style="font-size: 50px;" href="part1.jsp"> Перейти к Part1</a> <a style="font-size: 50px;" href="part3.jsp"> || Перейти к Part3</a>
	</center>
</body>
</html>