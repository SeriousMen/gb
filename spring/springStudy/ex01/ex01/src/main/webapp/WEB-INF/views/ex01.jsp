<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX01</title>
</head>
<body>
	<h1>EX01</h1>

	<h2>	<!--객체는 앞에 대문자인 것을 소문자로 EL문을 써주면 출력이된다. SampleDTO의 필드를 가져와서 호출  -->
		Model :name(${sampleDTO.name}) age(${sampleDTO.age})
	</h2>
	
	<!--http://localhost:8082/sample/ex01?name=김득구&&age=3  -->
</body>
</html>