<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function beforeSend() {
		var frm = document.getElementById("frm");
		if (frm.g_title.value == "") {
			alert("제목이 입력되지 않았습니다.");
			return false;
		} else if (frm.img.value == "") {
			alert("사진이 등록되지 않았습니다.")
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form:form id="frm" onsubmit="return beforeSend()" enctype="multipart/form-data">
		<p>
			제목 : <input type="text" name="g_title">
		</p>
		<p>
			이미지 : <input type="file" name="img" accept="image/*"> <!-- accept 이미지 파일만 선택할 수 있게끔 --> 
		</p>
		<input type="submit" value="사진등록">
	</form:form>
</body>
</html>