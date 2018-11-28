<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form>
		<p>
			<label for="y_url">URL등록</label>
			<input type="text" name="y_url" id="y_url">
		</p>
		<input type="submit" value="URL 등록">
	</form:form>
</body>
</html>