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
			<label for="u_id">아이디</label>
			<input type="text" id="u_id" name="u_id">
		</p>
		<p>
			<label for="u_pw">비밀번호</label>
			<input type="password" id="u_pw" name="u_pw">
		</p>
		<p>
			<label for="u_name">이름</label>
			<input type="text" id="u_name" name="u_name">
		</p>
		<input type="hidden" name="u_auth" value="USER">
		<input type="submit" value="회원가입">
	</form:form>
</body>
</html>