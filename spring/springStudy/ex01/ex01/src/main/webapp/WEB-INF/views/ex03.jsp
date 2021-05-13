<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX03</title>
</head>
<body>
	<h1>EX03</h1>

	<h2>	<!--객체는 앞에 대문자인 것을 소문자로 EL문을 써주면 출력이된다.  -->
		ArrayList : 
		<c:forEach var="data" items="${datas}">
			<c:out value="${data}"/>&nbsp;&nbsp;
		</c:forEach>
	</h2>
</body>
</html>