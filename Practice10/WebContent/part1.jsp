<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Скреплет</title>
</head>
<body>
	<center>

		<a style="font-size: 35px;"><strong>ТАБЛИЦА УМНОЖЕНИЯ,
				ИСПОЛНЕННАЯ С ПОМОЩЬЮ СКРЕПЛЕТОВ</strong></a> </br>
		</br> </br>
		</br>
		<%
			StringBuilder s = new StringBuilder();
			s.append("<center><table border=\"5\" style=\"font-size: 50px;\">");
			for (int i = 0; i < 10; ++i) {
				s.append("<tr>");
				for (int j = 0; j < 10; ++j) {
					s.append("<td>");
					if (i == 0 && j == 0)
						continue;
					if (i == 0)
						s.append(j);
					else if (j == 0)
						s.append(i);
					else
						s.append(i * j);
					s.append("</td>");
				}
				s.append("</tr>");
			}
			s.append("</table></center>");
		%>
		<%=s.toString()%>

		<a style="font-size: 50px;" href="part2.jsp"> Перейти к Part2</a> <a style="font-size: 50px;" href="part3.jsp"> || Перейти к Part3</a>
	</center>
</body>
</html>