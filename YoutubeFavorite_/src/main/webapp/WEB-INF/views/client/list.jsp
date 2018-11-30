<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	클라이언트 리스트 화면
	<c:forEach items="${list}" var="item">
		<div>
			<a href="detail?y_url=${item.y_url}">
				<img src="https://img.youtube.com/vi/${item.y_url}/maxresdefault.jpg">
				${item.y_title}
			</a>
		</div>
	</c:forEach>
	
</body>
</html>