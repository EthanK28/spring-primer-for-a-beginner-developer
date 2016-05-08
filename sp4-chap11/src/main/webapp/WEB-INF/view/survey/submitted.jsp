<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>응ㄷ바 내용</title>
</head>
<body>
	<p>응답내용:</p>
	<ul>
		<c:forEach var="response" items="${ansData.responses}" varStatus="status">
			<li>${status.index}번 문항 : ${response}</li>
		</c:forEach>
	</ul>
	<p>응답자 위치: ${ansData.res.location}</p>
	<p>응답자 위치: ${ansData.res.age}</p>	
	
</body>
</html>