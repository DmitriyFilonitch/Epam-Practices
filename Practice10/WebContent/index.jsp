<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

	<form action="getConnection">		
		<input name="type" type="submit" value="MYSQL"><br>
		<input name="type" type="submit" value="DERBY">
	</form>
	
	<c:if test="${not empty con}">
		<hr>
		<c:out value="${con}"/>
	</c:if>

</body>
</html>
